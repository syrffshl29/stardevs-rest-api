package com.starcodes.tabungin.service;

import com.starcodes.tabungin.model.Setoran;

import com.starcodes.tabungin.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepositServiceImpl {

	//implementasi dari DepositService

    @Autowired
    private DepositRepository depositRepository;

    public Object save(Setoran setoran) {
        depositRepository.save(setoran);
        return "Data Berhasil Disimpan";
    }
    public List<Setoran> findAll() {
        return depositRepository.findAll();
    }
    public Optional<Setoran> findById(long id) {
        return depositRepository.findById(id);
    }
}