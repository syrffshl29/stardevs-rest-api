package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.LoginDto;
import com.starcodes.tabungin.dto.validation.RegisterDto;
import com.starcodes.tabungin.dto.validation.VerifyRegisterDto;
import com.starcodes.tabungin.security.AESGeneratedKey;
import com.starcodes.tabungin.service.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthServiceImpl authServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterDto registerDto
            , HttpServletRequest request

    ){
        return authServiceImpl.register(authServiceImpl.mapToUser(registerDto),request);

//        return new ResponseHandler().handleResponse("DATA DITERIMA", HttpStatus.OK,"OK",null,request);
    }

    @PostMapping("/register/upload/{id}")
    public ResponseEntity<Object>  registrationUpload(
            @PathVariable Long id,
            @RequestParam MultipartFile file
            , HttpServletRequest request

    ){
        return authServiceImpl.getImage(id,file,request);
//        return new ResponseHandler().handleResponse("BERHASIL UPLOAD", HttpStatus.OK,"OK",null,request);
    }

    @PostMapping("/verify-register")
    public ResponseEntity<Object> verifyRegis(@Valid @RequestBody VerifyRegisterDto verifyRegisterDto
            , HttpServletRequest request){
        return authServiceImpl.verifyRegis(authServiceImpl.mapToUser(verifyRegisterDto),request);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginDto loginDto
            , HttpServletRequest request){
        return authServiceImpl.login(authServiceImpl.mapToUser(loginDto),request);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Object> tokenExpired(@Valid @RequestBody LoginDto loginDto
            , HttpServletRequest request){
        return authServiceImpl.refreshToken(authServiceImpl.mapToUser(loginDto),request);
    }

    @GetMapping("/gen-key")
    public String tokenExpired(){
        return "Your Key : "+ AESGeneratedKey.getKey();
    }
//    @PostMapping("/lupapasswordstepone")
//    public Object lupaPasswordStepOne(@Valid @RequestBody LupaPasswordStepOneDTO lupaPasswordStepOneDTO,
//    HttpServletRequest request){
//
//        User user = new User();
//        user.setEmail(lupaPasswordStepOneDTO.getEmail());
//        return authService.lupaPasswordStepOne(user, request);
//    }
//
//    @PostMapping("/lupapasswordsteptwo")
//    public Object lupaPasswordStepTwo(@Valid @RequestBody LupaPasswordStepTwoDTO lupaPasswordStepTwoDTO,
//                                      HttpServletRequest request){
//
//        User user = new User();
//        user.setEmail(lupaPasswordStepTwoDTO.getEmail());
//        user.setTokenEstafet(lupaPasswordStepTwoDTO.getTokenEstafet());
//        user.setOtp(lupaPasswordStepTwoDTO.getOtp());
//        return authService.lupaPasswordStepTwo(user, request);
//    }
//
//    @PostMapping("/lupapasswordstepthree")
//    public Object lupaPasswordStepThree(@Valid @RequestBody LupaPasswordStepThreeDTO lupaPasswordStepThreeDTO,
//                                      HttpServletRequest request){
//
//        User user = new User();
//        user.setEmail(lupaPasswordStepThreeDTO.getEmail());
//        user.setPassword(lupaPasswordStepThreeDTO.getPassword());
//        user.setPasswordConfirmation(lupaPasswordStepThreeDTO.getPasswordConfirmation());
//        user.setTokenEstafet(lupaPasswordStepThreeDTO.getTokenEstafet());
//        return authService.lupaPasswordStepThree(user, request);
//    }


}
