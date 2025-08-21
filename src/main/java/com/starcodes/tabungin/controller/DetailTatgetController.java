package com.starcodes.tabungin.controller;

import com.starcodes.tabungin.core.interfaces.TargetService;
import com.starcodes.tabungin.service.TargetServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("target/detail")
public class DetailTatgetController {

        @Autowired
        private TargetService targetService;

        @GetMapping("/{targetId}")
        public ResponseEntity<Object> getDetailTarget(@PathVariable Long targetId, HttpServletRequest request) {
            return targetService.findDetailTarget(targetId, request);
        }
}
