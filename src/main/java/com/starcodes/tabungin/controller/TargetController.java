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
    @PostMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
                                         @RequestBody ValTargetTabunganDto valTargetTabunganDto,
                                         HttpServletRequest request) {
        // Service akan map DTO ke model dan update
        return targetServiceImpl.update(id, targetServiceImpl.mapToModelMapper(valTargetTabunganDto), request);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id, HttpServletRequest request) {
        return targetServiceImpl.findById(id, null, request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id, HttpServletRequest request) {
        return targetServiceImpl.delete(id, null, request);
    }
}