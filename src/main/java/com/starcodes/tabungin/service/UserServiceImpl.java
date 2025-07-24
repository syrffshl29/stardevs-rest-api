package com.starcodes.tabungin.service;

import com.starcodes.tabungin.model.Users;
import com.starcodes.tabungin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl {

    //implementasi dari UserService

    @Autowired
    private UserRepository userRepository;

    public Object save(Users user) {
        userRepository.save(user);
        return "Data Berhasil Disimpan";
    }
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }
}