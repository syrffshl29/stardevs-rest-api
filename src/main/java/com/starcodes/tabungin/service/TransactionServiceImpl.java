package com.starcodes.tabungin.service;

import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl {

	//implementasi dari TransactionService

    @Autowired
    TransactionRepository transactionRepository;

    public Object save(TransaksiTabungan transaksiTabungan) {
        transactionRepository.save(transaksiTabungan);
        return "Data Berhasil Disimpan";
    }
    public List<TransaksiTabungan> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<TransaksiTabungan> findById(Long id) {
        return transactionRepository.findById(id);
    }
}