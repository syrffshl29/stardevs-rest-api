package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.model.LogAktivitas;
import com.starcodes.tabungin.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LogActifityController {

    @Autowired
    ReportServiceImpl reportServiceImpl;

    @PostMapping
    public Object save(@RequestBody LogAktivitas logAktivitas) {
    return  reportServiceImpl.save(logAktivitas);
    }

    @GetMapping("/all")
    public Object findAll() {
        return reportServiceImpl.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LogAktivitas>findLogAktivitasById(@PathVariable Long id) {
        return reportServiceImpl.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
