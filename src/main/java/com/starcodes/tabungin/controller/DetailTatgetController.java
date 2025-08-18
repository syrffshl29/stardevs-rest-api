package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.model.DetailTarget;
import com.starcodes.tabungin.model.Setoran;
import com.starcodes.tabungin.service.DetailTargetServiceImpl;
import com.starcodes.tabungin.service.TargetServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail")
public class DetailTatgetController {

        @Autowired
        private DetailTargetServiceImpl detailTargetServiceImpl;

        @GetMapping("/all")
        public Object findAll(HttpServletRequest request, Pageable pageable) {
            return detailTargetServiceImpl.findAll();
        }
        @GetMapping("/{id}")
        public ResponseEntity<DetailTarget> getUserById(@PathVariable Long id) {
            return detailTargetServiceImpl.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
}
