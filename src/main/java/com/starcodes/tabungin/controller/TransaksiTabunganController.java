package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTransactionDto;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiTabunganController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValTransactionDto valTransactionDto) {
        return transactionServiceImpl.save(valTransactionDto);
    }
    @GetMapping("/all")
    public Object findAll() {
        return transactionServiceImpl.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransaksiTabungan> getUserById(@PathVariable Long id) {
        return transactionServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
