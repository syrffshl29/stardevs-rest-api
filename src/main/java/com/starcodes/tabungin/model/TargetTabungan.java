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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

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
    @JoinColumn(name = "user_id",nullable=false)
    private Users userId;



    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}
