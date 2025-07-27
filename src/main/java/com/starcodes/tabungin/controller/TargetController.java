package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.TargetTabunganDto;
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
    public Object save(@RequestBody TargetTabunganDto targetTabunganDto) {
        return targetServiceImpl.save(targetTabunganDto);

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
