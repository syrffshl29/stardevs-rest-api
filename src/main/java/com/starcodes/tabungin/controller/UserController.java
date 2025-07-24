package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.starcodes.tabungin.model.Users;


@RestController // Ganti @RestController menjadi @Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping
    public Object save (@RequestBody Users user){

        System.out.println("Username : "+user.getUsername());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email	 : "+user.getEmail());
        System.out.println("Fullname : "+user.getFullName());
        System.out.println("Phone 	 : "+user.getPhone());
        System.out.println("Is Active: "+user.getActive());

        return userServiceImpl.save(user);
    }
    @GetMapping("/all")
    public Object getAllUsers(){
        return userServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return userServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

