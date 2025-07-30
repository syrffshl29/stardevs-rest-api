package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.service.TargetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target")
public class TargetController {

    @Autowired
    TargetServiceImpl targetServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValTargetTabunganDto valTargetTabunganDto) {
        return targetServiceImpl.save(valTargetTabunganDto);
    }
    @GetMapping("/all")
    public Object getAllTarget() {
        return targetServiceImpl.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TargetTabungan> getTargetById(@PathVariable Long id) {
        return targetServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}