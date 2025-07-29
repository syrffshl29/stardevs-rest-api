package com.starcodes.tabungin.model;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "target_tabungan")
public class TargetTabungan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_target", nullable = false)
    private String targetName;

    @Column(name = "jumlah_data_target", nullable = false)
    private Long jumlahDataTarget;

    @Column(name = "saldo_terkumpul")
    private Long saldoTerkumpul;

    @Column(name = "periode")
    private String periode;

    @Column(name = "deskrips")
    private String deskripsi;

    @Column(name = "tanggal_mulai_target")
    private LocalDate tanggalMulaiTarget;

    @Column(name = "tanggal_selesai_target")
    private LocalDate tanggalSelesaiTarget;

    @Column(name = "status_target")
    private String statusTarget;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
