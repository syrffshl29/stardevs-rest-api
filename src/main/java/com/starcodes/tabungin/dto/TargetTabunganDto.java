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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Long getJumlahDataTarget() {
        return jumlahDataTarget;
    }

    public void setJumlahDataTarget(Long jumlahDataTarget) {
        this.jumlahDataTarget = jumlahDataTarget;
    }

    public Long getSaldoTerkumpul() {
        return saldoTerkumpul;
    }

    public void setSaldoTerkumpul(Long saldoTerkumpul) {
        this.saldoTerkumpul = saldoTerkumpul;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public LocalDate getTanggalMulaiTarget() {
        return tanggalMulaiTarget;
    }

    public void setTanggalMulaiTarget(LocalDate tanggalMulaiTarget) {
        this.tanggalMulaiTarget = tanggalMulaiTarget;
    }

    public LocalDate getTanggalSelesaiTarget() {
        return tanggalSelesaiTarget;
    }

    public void setTanggalSelesaiTarget(LocalDate tanggalSelesaiTarget) {
        this.tanggalSelesaiTarget = tanggalSelesaiTarget;
    }

    public String getStatusTarget() {
        return statusTarget;
    }

    public void setStatusTarget(String statusTarget) {
        this.statusTarget = statusTarget;
    }
}
