package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValUserDto;
import com.starcodes.tabungin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.starcodes.tabungin.model.User;


@RestController // Ganti @RestController menjadi @Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public Object save (@RequestBody ValUserDto valUserDto){
        return userServiceImpl.save(userServiceImpl.mapToModelMapper(valUserDto));
    }
    @GetMapping("/all")
    public Object getAllUsers(){
        return userServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

