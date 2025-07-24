package com.starcodes.tabungin.service;

import com.starcodes.tabungin.model.LogAktivitas;
import com.starcodes.tabungin.repository.LogActifityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl {

	//implementasi dari ReportService

    @Autowired
    private LogActifityRepository logActifityRepository;

    public Object save(LogAktivitas logAktivitas) {
    logActifityRepository.save(logAktivitas);
    return "Data Berhasil Disimpan";
    }
    public List<LogAktivitas> findAll() {
        return logActifityRepository.findAll();
    }
    public Optional<LogAktivitas> findById(Long id) {
        return logActifityRepository.findById(id);
    }
}