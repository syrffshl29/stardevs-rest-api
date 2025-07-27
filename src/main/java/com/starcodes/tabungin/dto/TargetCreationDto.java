package com.starcodes.tabungin.dto;

public class TargetCreationDto {

    private String namaTarget;
    private Double jumlahTarget;
    private Integer durasiBulan;
    private String kategori;
    private String deskripsi;

    public String getNamaTarget() {
        return namaTarget;
    }

    public void setNamaTarget(String namaTarget) {
        this.namaTarget = namaTarget;
    }

    public Double getJumlahTarget() {
        return jumlahTarget;
    }

    public void setJumlahTarget(Double jumlahTarget) {
        this.jumlahTarget = jumlahTarget;
    }

    public Integer getDurasiBulan() {
        return durasiBulan;
    }

    public void setDurasiBulan(Integer durasiBulan) {
        this.durasiBulan = durasiBulan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
