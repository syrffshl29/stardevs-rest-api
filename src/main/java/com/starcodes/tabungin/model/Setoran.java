package com.starcodes.tabungin.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "setoran")
public class Setoran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "transaksi_id")
    private Long transaksiId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "jumlah_setoran")
    private double jumlahSetoran;

    @Column(name = "sumber_dana")
    private String sumberDana;

    @Column(name = "bukti_setoran")
    private String buktiSetoran;

    @Column(name = "status_verifikasi")
    private String statusVerifikasi;

    @Column(name = "tanggal_setoran")
    private LocalDateTime tanggalSetoran;

    @Column(name = "catatan_setoran")
    private String catatanSetoran;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(Long transaksiId) {
        this.transaksiId = transaksiId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public double getJumlahSetoran() {
        return jumlahSetoran;
    }

    public void setJumlahSetoran(double jumlahSetoran) {
        this.jumlahSetoran = jumlahSetoran;
    }

    public String getSumberDana() {
        return sumberDana;
    }

    public void setSumberDana(String sumberDana) {
        this.sumberDana = sumberDana;
    }

    public String getBuktiSetoran() {
        return buktiSetoran;
    }

    public void setBuktiSetoran(String buktiSetoran) {
        this.buktiSetoran = buktiSetoran;
    }

    public String getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(String statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    public LocalDateTime getTanggalSetoran() {
        return tanggalSetoran;
    }

    public void setTanggalSetoran(LocalDateTime tanggalSetoran) {
        this.tanggalSetoran = tanggalSetoran;
    }

    public String getCatatanSetoran() {
        return catatanSetoran;
    }

    public void setCatatanSetoran(String catatanSetoran) {
        this.catatanSetoran = catatanSetoran;
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
