package com.starcodes.tabungin.service;

import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TargetServiceImpl {

	//implementasi dari TargetService
    @Autowired
    TargetRepository targetRepository;

    public Object save(TargetTabungan targetTabungan) {
        targetRepository.save(targetTabungan);
        return "Data Berhasil Disimpan";
    }
    public List<TargetTabungan> findAll() {
        return targetRepository.findAll();
    }
    public Optional<TargetTabungan> findById(long id) {
        return targetRepository.findById(id);
    }
}