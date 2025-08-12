package com.starcodes.tabungin.repository;

import com.starcodes.tabungin.model.Akses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AksesRepository extends JpaRepository<Akses,Long> {
}
