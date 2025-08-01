package com.starcodes.tabungin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starcodes.tabungin.model.TargetTabungan;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository extends JpaRepository<TargetTabungan, Long> {

	//CRUD model TargetTabungan
}
