package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.service.TargetServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target")
public class TargetController {

    @Autowired
    TargetServiceImpl targetServiceImpl;

    @PostMapping
    public Object save(@RequestBody ValTargetTabunganDto valTargetTabunganDto,
                       HttpServletRequest request){
        return targetServiceImpl.save(targetServiceImpl.mapToModelMapper(valTargetTabunganDto),request);
    }
    @GetMapping("/all")
    public Object findAll(HttpServletRequest request, Pageable pageable){
        return targetServiceImpl.findAll(pageable,request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id, HttpServletRequest request) {
        return targetServiceImpl.findById(id, null, request);
    }

}