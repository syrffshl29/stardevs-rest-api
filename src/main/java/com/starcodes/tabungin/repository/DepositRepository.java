package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.Setoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Setoran, Long> {
	//CRUD model setoran
}
