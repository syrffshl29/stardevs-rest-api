package com.starcodes.tabungin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starcodes.tabungin.model.TargetTabungan;

@Repository
public interface TargetRepository extends JpaRepository<TargetTabungan, Long> {


	//CRUD model TargetTabungan
}
