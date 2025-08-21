package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTransaksiTabunganDto;
import com.starcodes.tabungin.dto.validation.ValWithDrawDto;
import com.starcodes.tabungin.service.TransaksiServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiTabunganController {

    @Autowired
    private TransaksiServiceImpl transaksiServiceImpl;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ValTransaksiTabunganDto valTransaksiTabunganDto,
                                       HttpServletRequest request) {
        return transaksiServiceImpl.save(valTransaksiTabunganDto, request);
    }
    @GetMapping("/all")
    public ResponseEntity<Object> findAll(HttpServletRequest request, Pageable pageable) {
        return transaksiServiceImpl.findAll(pageable, request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id, HttpServletRequest request) {
        return transaksiServiceImpl.findById(id, null, request);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
                                         @RequestBody ValTransaksiTabunganDto valTransaksiTabunganDto,
                                         HttpServletRequest request) {
        return transaksiServiceImpl.update(id, transaksiServiceImpl.mapToEntity(valTransaksiTabunganDto), request);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id, HttpServletRequest request) {
        return transaksiServiceImpl.delete(id, null, request);
    }
    @GetMapping("/target/{targetId}")
    public ResponseEntity<Object> findByTargetId(@PathVariable Long targetId,
                                                 HttpServletRequest request) {
        return transaksiServiceImpl.findByTargetId(targetId, request);
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Object> withdraw(@RequestBody ValWithDrawDto val,
                                               HttpServletRequest request) {
        return transaksiServiceImpl.withdraw(val, request);
    }
    @PostMapping("/deposit")
    public ResponseEntity<Object> deposit(@RequestBody ValTransaksiTabunganDto val,
                                           HttpServletRequest request) {
        return transaksiServiceImpl.deposit(val, request);
    }
}