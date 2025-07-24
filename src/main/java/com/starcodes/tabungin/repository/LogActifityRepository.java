package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.LogAktivitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActifityRepository extends JpaRepository<LogAktivitas,Long> {
}
