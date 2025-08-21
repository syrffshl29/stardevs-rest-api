package com.starcodes.tabungin.service;

import com.starcodes.tabungin.core.interfaces.IService;
import com.starcodes.tabungin.core.interfaces.TargetService;
import com.starcodes.tabungin.dto.response.RespDetailTargetDto;
import com.starcodes.tabungin.dto.response.RespTargetTabunganDto;
import com.starcodes.tabungin.dto.response.RespTransaksiTabunganDto;
import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.UserRepository;
import com.starcodes.tabungin.security.JwtUtility;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TargetServiceImpl implements TargetService<TargetTabungan> {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private TransaksiServiceImpl transaksiServiceImpl;

    @Override
    public ResponseEntity<Object> save(TargetTabungan targetTabungan, HttpServletRequest request) {
        if(targetTabungan==null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST,null,"TRN01FV",request);
        }
        try {
            // Ambil JWT dari header
            String jwt = request.getHeader("Authorization");
            if(jwt != null && jwt.startsWith("Bearer ")) {
                jwt = jwt.substring(7);
                String username = jwtUtility.getUsernameFromToken(jwt);
                User user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User Tidak Ditemukan"));
                targetTabungan.setUser(user);
            } else {
                return new ResponseHandler().handleResponse("JWT Tidak Ditemukan", HttpStatus.UNAUTHORIZED, null, "TRN01FJ", request);
            }

            // Set field default
            targetTabungan.setCreatedAt(LocalDateTime.now());
            targetTabungan.setUpdatedAt(LocalDateTime.now());
            if(targetTabungan.getDanaTerkumpul() == null) targetTabungan.setDanaTerkumpul(0.0);
            if(targetTabungan.getStatusTarget() == null) targetTabungan.setStatusTarget("ACTIVE");

            targetRepository.save(targetTabungan);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"TRN01FE01",request);
        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return targetRepository.findById(id).map(data -> {
            targetRepository.delete(data);
            return new ResponseHandler().handleResponse("Data Berhasil Dihapus", HttpStatus.OK, null, null, request);
        }).orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FD", request));
    }

    @Override
    public ResponseEntity<Object> update(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return targetRepository.findById(id).map(existing -> {
            existing.setTargetName(targetTabungan.getTargetName());
            existing.setDeskripsi(targetTabungan.getDeskripsi());
            existing.setHargaTarget(targetTabungan.getHargaTarget());
            existing.setPeriode(targetTabungan.getPeriode());
            existing.setTanggalMulaiTarget(targetTabungan.getTanggalMulaiTarget());
            existing.setTanggalSelesaiTarget(targetTabungan.getTanggalSelesaiTarget());
            existing.setStatusTarget(targetTabungan.getStatusTarget());
            existing.setUpdatedAt(LocalDateTime.now());
            targetRepository.save(existing);
            return new ResponseHandler().handleResponse("Data Berhasil Diupdate", HttpStatus.OK, null, null, request);
        }).orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FU", request));
    }

    @Override
    public ResponseEntity<Object> findById(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return targetRepository.findById(id)
                .map(data -> {
                    RespTargetTabunganDto dto = modelMapper.map(data, RespTargetTabunganDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FI", request));
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try {
            List<TargetTabungan> targetList = targetRepository.findAll(pageable).getContent();
            List<RespTargetTabunganDto> respList = modelMapper.map(targetList, new TypeToken<List<RespTargetTabunganDto>>(){}.getType());
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, respList, null, request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return new ResponseHandler().handleResponse("Method Belum Implemented", HttpStatus.NOT_IMPLEMENTED, null, "TRN01FP", request);
    }



    @Override
    public ResponseEntity<Object> findByTargetId(Long targetId, HttpServletRequest request) {
        return null;
    }

    public TargetTabungan mapToModelMapper(ValTargetTabunganDto valTargetTabunganDto) {
        return modelMapper.map(valTargetTabunganDto, TargetTabungan.class);
    }
    @Override
    public ResponseEntity<Object> findDetailTarget(Long targetId, HttpServletRequest request) {
        return targetRepository.findById(targetId)
                .map(target -> {
                    // Ambil transaksi langsung sebagai list DTO
                    List<RespTransaksiTabunganDto> transaksiDtoList = transaksiServiceImpl.getListByTargetId(targetId);

                    // Hitung dana terkumpul
                    Double danaTerkumpul = transaksiDtoList.stream()
                            .mapToDouble(RespTransaksiTabunganDto::getJumlahTransaksi)
                            .sum();

                    // Hitung progress
                    double progress = 0;
                    if(target.getHargaTarget() != null && target.getHargaTarget() > 0){
                        progress = danaTerkumpul / target.getHargaTarget() * 100;
                    }

                    // Mapping ke RespDetailTargetDto
                    RespDetailTargetDto dto = new RespDetailTargetDto();
                    dto.setId(target.getId());
                    dto.setTargetName(target.getTargetName());
                    dto.setHargaTarget(target.getHargaTarget());
                    dto.setDanaTerkumpul(danaTerkumpul);
                    dto.setProgress(progress);
                    dto.setTanggalMulaiTarget(target.getTanggalMulaiTarget());
                    dto.setTanggalSelesaiTarget(target.getTanggalSelesaiTarget());
                    dto.setCatatan(target.getDeskripsi());
                    dto.setCreatedAt(target.getCreatedAt());
                    dto.setUpdatedAt(target.getUpdatedAt());
                    dto.setTransaksiList(transaksiDtoList);

                    return new ResponseHandler().handleResponse("Detail Target Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(() -> new ResponseHandler().handleResponse("Target Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FD", request));
    }
}