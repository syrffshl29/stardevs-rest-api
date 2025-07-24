package com.starcodes.tabungin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starcodes.tabungin.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}