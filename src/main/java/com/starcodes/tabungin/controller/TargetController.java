package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.TargetTabunganDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.Users;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/target")
public class TargetController {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createTarget(@RequestBody TargetTabunganDto dto) {
        Users user = userRepository.findById(dto.getUserId()).orElse(null);


        TargetTabungan target = new TargetTabungan();
        target.setUser(user);
        target.setTargetName(dto.getTargetName());
        target.setJumlahDataTarget(dto.getJumlahDataTarget());
        target.setSaldoTerkumpul(dto.getSaldoTerkumpul());
        target.setPeriode(dto.getPeriode());
        target.setDeskripsi(dto.getDeskripsi());
        target.setTanggalMulaiTarget(dto.getTanggalMulaiTarget());
        target.setTanggalSelesaiTarget(dto.getTanggalSelesaiTarget());
        target.setStatusTarget(dto.getStatusTarget());

        targetRepository.save(target);
        return ResponseEntity.ok("Target tabungan berhasil dibuat");
    }
    @GetMapping("/all")
    public List<TargetTabungan> getAllTarget() {
        return targetRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TargetTabungan> getTargetById(@PathVariable Long id) {
        return targetRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
