package com.starcodes.tabungin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="detail_target")
public class DetailTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "target_harian")
    private Integer targetHarian;

    @Column(name = "target_mingguan")
    private Integer targetMingguan;

    @Column(name = "strategi_menabung")
    private String strategiMenabung;

    @Column(name = "catatan")
    private String catatan;

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

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetHarian() {
        return targetHarian;
    }

    public void setTargetHarian(Integer targetHarian) {
        this.targetHarian = targetHarian;
    }

    public Integer getTargetMingguan() {
        return targetMingguan;
    }

    public void setTargetMingguan(Integer targetMingguan) {
        this.targetMingguan = targetMingguan;
    }

    public String getStrategiMenabung() {
        return strategiMenabung;
    }

    public void setStrategiMenabung(String strategiMenabung) {
        this.strategiMenabung = strategiMenabung;
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

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
