package com.starcodes.tabungin.config;

import com.starcodes.tabungin.model.Akses;
import com.starcodes.tabungin.repository.AksesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final AksesRepository aksesRepository;

    public DataInitializer(AksesRepository aksesRepository) {
        this.aksesRepository = aksesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (aksesRepository.count() == 0) {
            // Buat akses admin
            Akses admin = new Akses();
            admin.setNama("ADMIN");
            admin.setDeskripsi("Role Administrator dengan akses penuh");
            aksesRepository.save(admin);

            // Buat akses user biasa
            Akses user = new Akses();
            user.setNama("USER");
            user.setDeskripsi("Role User biasa dengan akses terbatas");
            aksesRepository.save(user);

            System.out.println("Data akses awal berhasil ditambahkan.");
        } else {
            System.out.println("Data akses sudah ada, tidak perlu inisialisasi.");
        }
    }
}
