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
    private TransactionServiceImpl transactionServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody ValTransactionDto valTransactionDto,
                                       HttpServletRequest request) {
        return transactionServiceImpl.save(valTransactionDto, request);
    }
    @GetMapping("/all")
    public ResponseEntity<Object> findAll(HttpServletRequest request, Pageable pageable) {
        return transactionServiceImpl.findAll(pageable, request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id, HttpServletRequest request) {
        return transactionServiceImpl.findById(id, null, request);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
                                         @RequestBody ValTransactionDto valTransactionDto,
                                         HttpServletRequest request) {
        return transactionServiceImpl.update(id, transactionServiceImpl.mapToEntity(valTransactionDto), request);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id, HttpServletRequest request) {
        return transactionServiceImpl.delete(id, null, request);
    }
}
