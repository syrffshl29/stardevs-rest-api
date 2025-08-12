package com.starcodes.tabungin.service;

import com.starcodes.tabungin.config.JwtConfig;
import com.starcodes.tabungin.dto.validation.LoginDto;
import com.starcodes.tabungin.dto.validation.MenuLoginDTO;
import com.starcodes.tabungin.dto.validation.RegisterDto;
import com.starcodes.tabungin.dto.validation.VerifyRegisterDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.Akses;
import com.starcodes.tabungin.model.Menu;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.UserRepository;
import com.starcodes.tabungin.security.BcryptImpl;
import com.starcodes.tabungin.security.Crypto;
import com.starcodes.tabungin.security.JwtUtility;
import com.starcodes.tabungin.util.LoggingFile;
import com.starcodes.tabungin.config.OtherConfig;
import com.starcodes.tabungin.util.RequestCapture;
import com.starcodes.tabungin.util.SendMailOTP;
import com.starcodes.tabungin.util.TransformationDataMenu;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@Transactional
public class AuthServiceImpl implements UserDetailsService {

    @Autowired private UserRepository userRepository;
    @Autowired private ModelMapper modelMapper;
    @Autowired private JwtUtility jwtUtility;

    private Random random = new Random();

    // Register user pakai User entity (biasanya dipanggil dari controller)
    public ResponseEntity<Object> register(User user, HttpServletRequest request) {
        if (user == null || user.getEmail() == null) {
            return new ResponseHandler().handleResponse("Email Tidak Ditemukan !!", HttpStatus.BAD_REQUEST, null, "TRN00FV001", request);
        }

        Map<String,Object> mapResponse = new HashMap<>();
        try {
            // Cek email sudah terdaftar?
            if(userRepository.findByEmail(user.getEmail()).isPresent()){
                return new ResponseHandler().handleResponse("Email sudah terdaftar", HttpStatus.BAD_REQUEST, null, "TRN00FV003", request);
            }

            int otp = random.nextInt(100000, 999999);
            user.setOtp(BcryptImpl.hash(String.valueOf(otp)));
            user.setPassword(BcryptImpl.hash(user.getUsername() + user.getPassword()));

            // Default akses id=2
            Akses role = new Akses();
            role.setId(2L);
            user.setAkses(role);

            userRepository.save(user);

            if ("y".equalsIgnoreCase(OtherConfig.getEnableAutomationTesting())) {
                mapResponse.put("otp", otp); // untuk automation testing
            }

            SendMailOTP.verifyRegisOTP("OTP UNTUK REGISTRASI",
                    user.getNamaLengkap(), user.getEmail(), String.valueOf(otp), "ver_regis.html");

            mapResponse.put("email", user.getEmail());
            mapResponse.put("id", user.getId());

            Thread.sleep(1000);

        } catch (Exception e) {
            LoggingFile.logException("AuthService", "register(User user, HttpServletRequest request)"+ RequestCapture.allRequest(request), e);
            return new ResponseHandler().handleResponse("Server Tidak Dapat Memproses !!", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN00FE001", request);
        }
        return new ResponseHandler().handleResponse("OTP Terkirim, Cek Email !!", HttpStatus.OK, mapResponse, null, request);
    }

    public ResponseEntity<Object> getImage(Long id, MultipartFile file, HttpServletRequest request){
        try {
            Optional<User> opUser = userRepository.findById(id);
            if (opUser.isEmpty()) {
                return new ResponseHandler().handleResponse("User Tidak Ditemukan", HttpStatus.BAD_REQUEST, null, "TRN00FV100", request);
            }
            User usrNext = opUser.get();
            usrNext.setLinkImage(file.getOriginalFilename());
            userRepository.save(usrNext);
        } catch (Exception e) {
            return new ResponseHandler().handleResponse("Gagal Upload File", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN00FE100", request);
        }
        return new ResponseHandler().handleResponse("File Berhasil Di Upload", HttpStatus.OK, null, null, request);
    }

    public ResponseEntity<Object> verifyRegis(User user, HttpServletRequest request) {
        try {
            Optional<User> opUser = userRepository.findByEmail(user.getEmail());
            if (opUser.isEmpty()) {
                return new ResponseHandler().handleResponse("Email Tidak Ditemukan !!", HttpStatus.BAD_REQUEST, null, "TRN00FV011", request);
            }
            User userNext = opUser.get();
            if (!BcryptImpl.verifyHash(user.getOtp(), userNext.getOtp())) {
                return new ResponseHandler().handleResponse("OTP Salah !!", HttpStatus.BAD_REQUEST, null, "TRN00FV012", request);
            }
            userNext.setRegistered(true);
            userNext.setModifiedBy(userNext.getId());
            // Reset OTP agar tidak bisa dipakai lagi
            userNext.setOtp(BcryptImpl.hash(String.valueOf(random.nextInt(100000, 999999))));
            userRepository.save(userNext);
        } catch (Exception e) {
            LoggingFile.logException("AuthService", "verifyRegis(User user, HttpServletRequest request)" + RequestCapture.allRequest(request), e);
            return new ResponseHandler().handleResponse("Terjadi Kesalahan Pada Server", HttpStatus.INTERNAL_SERVER_ERROR, null,
                    "TRN00FE011", request);
        }
        return new ResponseHandler().handleResponse("Registrasi Berhasil !!", HttpStatus.OK, null, null, request);
    }

    public ResponseEntity<Object> login(User user, HttpServletRequest request) {
        Map<String, Object> m = new HashMap<>();
        try {
            String username = user.getUsername();
            Optional<User> opUser = userRepository.findByUsernameOrEmailOrNoHpAndIsRegistered(username, username, username, true);
            if (opUser.isEmpty()) {
                return new ResponseHandler().handleResponse("User Tidak Ditemukan", HttpStatus.BAD_REQUEST, null, "TRN00FV021", request);
            }
            User userNext = opUser.get();

            String pwdDB = userNext.getUsername() + user.getPassword();
            if (!BcryptImpl.verifyHash(pwdDB, userNext.getPassword())) {
                return new ResponseHandler().handleResponse("Username atau Password Salah !!", HttpStatus.BAD_REQUEST, null, "TRN00FV022", request);
            }

            Map<String, Object> mapData = new HashMap<>();
            mapData.put("em", userNext.getEmail());
            mapData.put("id", userNext.getId());
            mapData.put("hp", userNext.getNoHp());
            mapData.put("naleng", userNext.getNamaLengkap());
            List<MenuLoginDTO> menu = mapToMenuLoginDTO(userNext.getAkses().getListMenu());
            String token = jwtUtility.doGenerateToken(mapData, userNext.getUsername());

            m.put("menu", new TransformationDataMenu().doTransformAksesMenuLogin(menu));
            m.put("menu", menu);
            if (JwtConfig.getTokenEncryptEnable().equals("y")) {
                token = Crypto.performEncrypt(token);
            }
            m.put("token", token);
            m.put("urlImage", userNext.getLinkImage());

        } catch (Exception e) {
            LoggingFile.logException("AuthService", "login(User user, HttpServletRequest request)" + RequestCapture.allRequest(request), e);
            return new ResponseHandler().handleResponse("Terjadi Kesalahan Pada Server", HttpStatus.INTERNAL_SERVER_ERROR, null,
                    "TRN00FE021", request);
        }
        return new ResponseHandler().handleResponse("Login Berhasil !!", HttpStatus.OK, m, null, request);
    }

    public ResponseEntity<Object> refreshToken(User user, HttpServletRequest request) {
        Map<String, Object> m = new HashMap<>();
        try {
            String username = user.getUsername();
            Optional<User> opUser = userRepository.findByUsernameOrEmailOrNoHpAndIsRegistered(username, username, username, true);
            if (opUser.isEmpty()) {
                return new ResponseHandler().handleResponse("User Tidak Ditemukan", HttpStatus.BAD_REQUEST, null, "TRN00FV021", request);
            }
            User userNext = opUser.get();

            String pwdDB = userNext.getUsername() + user.getPassword();
            if (!BcryptImpl.verifyHash(pwdDB, userNext.getPassword())) {
                return new ResponseHandler().handleResponse("Username atau Password Salah !!", HttpStatus.BAD_REQUEST, null, "TRN00FV022", request);
            }

            Map<String, Object> mapData = new HashMap<>();
            mapData.put("em", userNext.getEmail());
            mapData.put("id", userNext.getId());
            mapData.put("hp", userNext.getNoHp());
            mapData.put("naleng", userNext.getNamaLengkap());
            String token = jwtUtility.doGenerateToken(mapData, userNext.getUsername());
            if (JwtConfig.getTokenEncryptEnable().equals("y")) {
                token = Crypto.performEncrypt(token);
            }
            m.put("token", token);

        } catch (Exception e) {
            LoggingFile.logException("AuthService", "refreshToken(User user, HttpServletRequest request)" + RequestCapture.allRequest(request), e);
            return new ResponseHandler().handleResponse("Terjadi Kesalahan Pada Server", HttpStatus.INTERNAL_SERVER_ERROR, null,
                    "TRN00FE021", request);
        }
        return new ResponseHandler().handleResponse("Login Berhasil !!", HttpStatus.OK, m, null, request);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opUser = userRepository.findByUsernameAndIsRegistered(username, true);
        if (opUser.isEmpty()) {
            throw new UsernameNotFoundException("Username atau Password Salah !!!");
        }
        User user = opUser.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    public List<MenuLoginDTO> mapToMenuLoginDTO(List<Menu> ltMenu) {
        List<MenuLoginDTO> ltMenuDTO = new ArrayList<>();
        for (Menu menu : ltMenu) {
            MenuLoginDTO menuDTO = new MenuLoginDTO();
            menuDTO.setNama(menu.getNama());
            menuDTO.setPath(menu.getPath());
            menuDTO.setNamaGroupMenu(menu.getGroupMenu().getNama());
            ltMenuDTO.add(menuDTO);
        }
        return ltMenuDTO;
    }
    // Mapping manual jika perlu
    public User mapToUser(RegisterDto registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setNoHp(registerDTO.getNoHp());
        user.setNamaLengkap(registerDTO.getNamaLengkap());
        user.setPassword(registerDTO.getPassword());
        user.setUsername(registerDTO.getUsername());
        user.setAlamat(registerDTO.getAlamat());
        user.setTanggalLahir(registerDTO.getTanggalLahir());
        return user;
    }

    public User mapToUser(VerifyRegisterDto verifyRegisterDTO) {
        User user = new User();
        user.setEmail(verifyRegisterDTO.getEmail());
        user.setOtp(verifyRegisterDTO.getOtp());
        return user;
    }

    public User mapToUser(LoginDto loginDTO) {
        User user = new User();
        user.setUsername(loginDTO.getUsername());
        user.setPassword(loginDTO.getPassword());
        return user;
    }

    // Dengan ModelMapper
    public User mapToUserMapper(RegisterDto registerDTO) {
        return modelMapper.map(registerDTO, User.class);
    }

    public User mapToUserMapper(VerifyRegisterDto verifyRegisterDto) {
        return modelMapper.map(verifyRegisterDto, User.class);
    }

    public User mapToUserMapper(LoginDto loginDTO) {
        return modelMapper.map(loginDTO, User.class);
    }
}
