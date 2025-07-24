package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.starcodes.tabungin.model.Users;

import java.util.List;

@RestController // Ganti @RestController menjadi @Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Users createUser (@RequestBody Users user){

        System.out.println("Username : "+user.getUsername());
        System.out.println("Password : "+user.getPassword());
        System.out.println("Email	 : "+user.getEmail());
        System.out.println("Fullname : "+user.getFullName());
        System.out.println("Phone 	 : "+user.getPhone());
        System.out.println("Is Active: "+user.getActive());

        return userRepository.save(user);
    }
    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

