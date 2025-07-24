package com.starcodes.tabungin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class LogAktivitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "jenis_aktivitas")
    private String jenisaktivitas;

    @Column(name = "detail_aktivitas")
    private String detailaktivitas;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "data_tambahan")
    private String dataTambahan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJenisaktivitas() {
        return jenisaktivitas;
    }

    public void setJenisaktivitas(String jenisaktivitas) {
        this.jenisaktivitas = jenisaktivitas;
    }

    public String getDetailaktivitas() {
        return detailaktivitas;
    }

    public void setDetailaktivitas(String detailaktivitas) {
        this.detailaktivitas = detailaktivitas;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDataTambahan() {
        return dataTambahan;
    }

    public void setDataTambahan(String dataTambahan) {
        this.dataTambahan = dataTambahan;
    }
}
