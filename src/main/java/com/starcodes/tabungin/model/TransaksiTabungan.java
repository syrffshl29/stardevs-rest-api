package com.starcodes.tabungin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="transaksi_tabungan")
public class TransaksiTabungan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "jenis_transaksi")
    private String jenisTransaksi;

    @Column(name = "jumlah_transaksi")
    private double jumlahTransaksi;

    @Column(name = "metode_pembayaran")
    private String metodePembayaran;

    @Column(name = "status_transaksi")
    private String statusTransaksi;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "referensi_pembayaran")
    private String referensiPembayaran;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "target_id",nullable = false)
    private TargetTabungan targetTabungan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public double getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    public void setJumlahTransaksi(double jumlahTransaksi) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TargetTabungan getTargetTabungan() {
        return targetTabungan;
    }

    public void setTargetTabungan(TargetTabungan targetTabungan) {
        this.targetTabungan = targetTabungan;
    }
}
