package com.starcodes.tabungin.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private String jenisTransaksi;
    private Double jumlahTransaksi;
    private String metodePembayaran;
    private String statusTransaksi;
    private String keterangan;
    private String referensiPembayaran;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long targetId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public Double getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(Double jumlahTransaksi) {
        this.jumlahTransaksi = jumlahTransaksi;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getReferensiPembayaran() {
        return referensiPembayaran;
    }

    public void setReferensiPembayaran(String referensiPembayaran) {
        this.referensiPembayaran = referensiPembayaran;
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

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
