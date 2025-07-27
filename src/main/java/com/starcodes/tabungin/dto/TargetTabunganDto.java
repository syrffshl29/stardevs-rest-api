package com.starcodes.tabungin.dto;


import java.time.LocalDate;


public class TargetTabunganDto {

    private String targetName;
    private Long jumlahDataTarget;
    private Long saldoTerkumpul;
    private String periode;
    private String deskripsi;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}