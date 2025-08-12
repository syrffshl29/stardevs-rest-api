package com.starcodes.tabungin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Username" , length = 16, nullable = false, unique = true)
    private String username;

    @Column(name = "Email",length = 256,nullable = false, unique = true)
    private String email;

    @Column(name = "NoHp",length = 18,nullable = false,unique = true)//08,+62,62-- 0/62/+62
    private String noHp;

    @Column(name = "Password",length = 64,nullable = false)
    private String password;

    @Column(name = "NamaLengkap",length = 70,nullable = false)
    private String namaLengkap;

    @Column(name = "Alamat",length = 256,nullable = false)
    private String alamat;

    @Column(name = "TanggalLahir",nullable = false)
    private LocalDate tanggalLahir;

    @Transient
    private Integer umur;

    @Transient
    private String passwordConfirmation;

    @Column(name = "OTP",length = 64)
    private String otp;

    @Column(name = "IsRegistered")
    private Boolean isRegistered;

    @Column(name = "LinkImage", length = 256)
    private String linkImage;

    @Column(name = "PathImage",length = 256)
    private String pathImage;

    @Column(name = "CreatedBy",nullable = false,updatable = false)
    private Long createdBy=1L;

    @Column(name = "CreatedDate",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "ModifiedBy",insertable = false)
    private Long modifiedBy;

    @Column(name = "ModifiedDate",insertable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @Column(name = "TokenEstafet",length = 64)
    private String tokenEstafet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDAkses",foreignKey = @ForeignKey(name = "fk-user-to-akses"))
    private Akses akses;

    /** disini letak role dari user nya yang akan di baca di API nanti */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Menu> lt = this.akses.getListMenu();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Menu m :lt) {
            grantedAuthorities.add(new SimpleGrantedAuthority(m.getNama()));
        }
        return grantedAuthorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Boolean getRegistered() {
        return isRegistered;
    }

    public void setRegistered(Boolean registered) {
        isRegistered = registered;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getTokenEstafet() {
        return tokenEstafet;
    }

    public void setTokenEstafet(String tokenEstafet) {
        this.tokenEstafet = tokenEstafet;
    }

    public Akses getAkses() {
        return akses;
    }

    public void setAkses(Akses akses) {
        this.akses = akses;
    }
}




