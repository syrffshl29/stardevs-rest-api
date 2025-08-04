package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.LogAktivitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTargetRepository extends JpaRepository<LogAktivitas,Long> {
}
