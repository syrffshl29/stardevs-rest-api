package com.starcodes.tabungin.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RespDetailTargetDto {

    private Long id;
    private String targetName;
    private Double hargaTarget;
    private LocalDate tanggalMulaiTarget;
    private LocalDate tanggalSelesaiTarget;
    private Double danaTerkumpul;
    private String catatan;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Double progress;
    private List<RespTransaksiTabunganDto> transaksiList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RespTransaksiTabunganDto> getTransaksiList() {
        return transaksiList;
    }

    public void setTransaksiList(List<RespTransaksiTabunganDto> transaksiList) {
        this.transaksiList = transaksiList;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Double getHargaTarget() {
        return hargaTarget;
    }

    public void setHargaTarget(Double hargaTarget) {
        this.hargaTarget = hargaTarget;
    }

    public Double getDanaTerkumpul() {
        return danaTerkumpul;
    }

    public void setDanaTerkumpul(Double danaTerkumpul) {
        this.danaTerkumpul = danaTerkumpul;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getProgress() {
        return this.danaTerkumpul != null && this.hargaTarget != null
                ? (this.danaTerkumpul / this.hargaTarget) * 100
                : 0;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
