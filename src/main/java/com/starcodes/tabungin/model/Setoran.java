package com.starcodes.tabungin.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "setoran")
public class Setoran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setoran_id")
    private Long id;
    private Long targetId;
    @Column(name = "jumlah_setoran")
    private Double jumlahSetoran;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "transaksi_id", nullable = false)
    private TransaksiTabungan transaksiTabungan;
    @ManyToOne
    @JoinColumn(name = "target_id", nullable = false)
    private TargetTabungan targetTabungan;

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

    public Double getJumlahSetoran() {
        return jumlahSetoran;
    }

    public void setJumlahSetoran(Double jumlahSetoran) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TransaksiTabungan getTransaksiTabungan() {
        return transaksiTabungan;
    }

    public void setTransaksiTabungan(TransaksiTabungan transaksiTabungan) {
        this.transaksiTabungan = transaksiTabungan;
    }

    public TargetTabungan getTargetTabungan() {
        return targetTabungan;
    }

    public void setTargetTabungan(TargetTabungan targetTabungan) {
        this.targetTabungan = targetTabungan;
    }
}