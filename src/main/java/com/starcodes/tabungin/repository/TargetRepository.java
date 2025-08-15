package com.starcodes.tabungin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starcodes.tabungin.model.TargetTabungan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetRepository extends JpaRepository<TargetTabungan, Long> {

    List<TargetTabungan>findByUserId(Long userId);
	//CRUD model TargetTabungan
}
