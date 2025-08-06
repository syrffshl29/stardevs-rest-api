package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTransactionDto;
import com.starcodes.tabungin.service.TransactionServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiTabunganController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValTransactionDto valTransactionDto,
                       HttpServletRequest request) {
        return transactionServiceImpl.save(transactionServiceImpl.mapToModelMapper(valTransactionDto),request);
    }
    @GetMapping("/all")
    public Object findAll(HttpServletRequest request, Pageable pageable) {
        return transactionServiceImpl.findAll(pageable,request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id, HttpServletRequest request) {
    return transactionServiceImpl.findById(id, null, request);
    }
}
