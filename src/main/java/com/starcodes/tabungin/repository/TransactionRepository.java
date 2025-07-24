package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.TransaksiTabungan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransaksiTabungan, Long> {
	//CRUD model TransaksiTabungan
}
