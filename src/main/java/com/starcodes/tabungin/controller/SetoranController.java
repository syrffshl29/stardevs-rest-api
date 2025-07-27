package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.model.Setoran;
import com.starcodes.tabungin.service.DepositServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/setoran")
public class SetoranController {

    @Autowired
    DepositServiceImpl depositServiceImpl;

    @PostMapping
    public Object save(@RequestBody Setoran setoran) {
        return depositServiceImpl.save(setoran);
    }
    @GetMapping("/all")
    public Object findAllSetoran() {
        return depositServiceImpl.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Setoran> getSetoranById(@PathVariable Long id) {
        return depositServiceImpl.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


}
