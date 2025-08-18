package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.TransaksiTabungan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransaksiTabungan, Long> {

    // Cari semua transaksi berdasarkan username

    // Query lain tetap bisa
    List<TransaksiTabungan> findByJenisTransaksiContainingIgnoreCase(String jenisTransaksi);
    List<TransaksiTabungan> findByStatusTransaksiContainingIgnoreCase(String statusTransaksi);
    List<TransaksiTabungan> findByKeteranganContainingIgnoreCase(String keterangan);
}
