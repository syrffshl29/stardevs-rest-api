package com.starcodes.tabungin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "target_tabungan")
public class TargetTabungan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "target_id")
    private Long id;

    @Column(name = "nama_target", nullable = false)
    private String targetName;

    @Column(name = "harga_target", nullable = false)
    private Double hargaTarget;

    @Column(name = "dana_terkumpul")
    private Double danaTerkumpul;

    @Column(name = "periode")
    private String periode;

    @Column(name = "deskripsi")
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
    private User user;

    @OneToMany(mappedBy = "targetTabungan",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TransaksiTabungan> transaksiTabunganList;

    @OneToMany(mappedBy = "targetTabungan")
    @JsonIgnore
    private  List<Setoran> setoranList;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TransaksiTabungan> getTransaksiTabunganList() {
        return transaksiTabunganList;
    }

    public void setTransaksiTabunganList(List<TransaksiTabungan> transaksiTabunganList) {
        this.transaksiTabunganList = transaksiTabunganList;
    }

    public List<Setoran> getSetoranList() {
        return setoranList;
    }

    public void setSetoranList(List<Setoran> setoranList) {
        this.setoranList = setoranList;
    }
}
