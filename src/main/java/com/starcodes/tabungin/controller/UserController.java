package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValUserDto;
import com.starcodes.tabungin.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValUserDto valUserDto,
                       HttpServletRequest request){
        return userServiceImpl.save(userServiceImpl.mapToModelMapper(valUserDto),request);
    }
    @GetMapping
    public Object findAll(HttpServletRequest request, Pageable pageable){

        return userServiceImpl.findAll(pageable,request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id, HttpServletRequest request) {
        return userServiceImpl.findById(id, null, request);
    }
}

