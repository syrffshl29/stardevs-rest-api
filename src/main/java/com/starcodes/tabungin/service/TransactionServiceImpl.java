package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.response.RespTransactionDto;
import com.starcodes.tabungin.dto.validation.ValTransactionDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.TransactionRepository;
import com.starcodes.tabungin.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl {

	//implementasi dari TransactionService

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object save(ValTransactionDto valTransactionDto) {
        Optional<User> userOpt = userRepository.findById(valTransactionDto.getUserId());
        Optional<TargetTabungan> targetTabunganOpt = targetRepository.findById(valTransactionDto.getTargetId());
        if (userOpt.isEmpty()) {
            return "User not found";
        }
        if (targetTabunganOpt.isEmpty()) {
            return "Target Tabungan not found";
        }
        TransaksiTabungan transaksiTabungan = mapToModel(valTransactionDto);
        transaksiTabungan.setUser(userOpt.get());
        transaksiTabungan.setTargetTabungan(targetTabunganOpt.get());
        transactionRepository.save(transaksiTabungan);
        return "Data berhasil disimpan";
    }
    public List<TransaksiTabungan> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<TransaksiTabungan> findById(Long id) {
        return transactionRepository.findById(id);
    }
    public TransaksiTabungan mapToModel(ValTransactionDto valTransactionDto) {
        TransaksiTabungan transaction = new TransaksiTabungan();
        transaction.setJenisTransaksi(valTransactionDto.getJenisTransaksi());
        transaction.setJumlahTransaksi(valTransactionDto.getJumlahTransaksi());
        transaction.setMetodePembayaran(valTransactionDto.getMetodePembayaran());
        transaction.setStatusTransaksi(valTransactionDto.getStatusTransaksi());
        transaction.setKeterangan(valTransactionDto.getKeterangan());
        transaction.setReferensiPembayaran(valTransactionDto.getReferensiPembayaran());
        transaction.setCreatedAt(valTransactionDto.getCreatedAt());
        transaction.setUpdatedAt(valTransactionDto.getUpdatedAt());
        return transaction;
    }
    public List<RespTransactionDto> mapToModelMapper(List<TransaksiTabungan> transaksiList) {
        return modelMapper.map(transaksiList, new TypeToken<List<RespTransactionDto>>() {
        }.getType());
    }
}