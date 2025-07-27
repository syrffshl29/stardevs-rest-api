package com.starcodes.tabungin.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TargetTabunganDto {
    private Long userId;
    private String targetName;
    private Long jumlahDataTarget;
    private Long saldoTerkumpul;
    private String periode;
    private String deskripsi;
    private LocalDate tanggalMulaiTarget;
    private LocalDate tanggalSelesaiTarget;
    private String statusTarget;
}
