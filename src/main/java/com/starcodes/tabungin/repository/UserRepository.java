package com.starcodes.tabungin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starcodes.tabungin.model.Users;

@Repository
    public interface UserRepository extends JpaRepository<Users, Long> {
}