package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValDepositoDto;
import com.starcodes.tabungin.model.Setoran;
import com.starcodes.tabungin.service.DepositServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setoran")
public class SetoranController {

    @Autowired
    DepositServiceImpl depositServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValDepositoDto valDepositoDto,
                       HttpServletRequest request) {
        return depositServiceImpl.save(depositServiceImpl.mapToModelMapper(valDepositoDto),request);
    }
    @GetMapping("/all")
    public Object findAll(HttpServletRequest request, Pageable pageable) {
        return depositServiceImpl.findAll(pageable,request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id, HttpServletRequest request) {
        return depositServiceImpl.findById(id,null,request);
    }
}
