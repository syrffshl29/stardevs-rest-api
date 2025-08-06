package com.starcodes.tabungin.service;

import com.starcodes.tabungin.core.interfaces.IService;
import com.starcodes.tabungin.dto.response.RespTransactionDto;
import com.starcodes.tabungin.dto.validation.ValTransactionDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.repository.TransactionRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements IService<TransaksiTabungan> {

	//implementasi dari TransactionService

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> save(TransaksiTabungan transaksiTabungan, HttpServletRequest request) {
        if(transaksiTabungan==null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST,null,"TRN01FV",request);
        }
        try{
            transactionRepository.save(transaksiTabungan);
        }catch(Exception e){
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"TRN01FE01",request);

        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, TransaksiTabungan transaksiTabungan, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> update(Long id, TransaksiTabungan transaksiTabungan, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id, TransaksiTabungan transaksiTabungan, HttpServletRequest request) {
        return transactionRepository.findById(id)
                .map(data->{
                    RespTransactionDto dto = modelMapper.map(data, RespTransactionDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(()-> new ResponseHandler().handleResponse("Data Tidak Ditemukan",HttpStatus.NOT_FOUND,null,null,request));
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try {
            List<TransaksiTabungan> transaksiList = transactionRepository.findAll();
            List<RespTransactionDto> respList = mapToModelMapper(transaksiList);
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, respList, null, request);
        } catch (Exception e) {
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return null;
    }
    public TransaksiTabungan mapToModelMapper(ValTransactionDto valTransactionDto) {
        return modelMapper.map(valTransactionDto, TransaksiTabungan.class);
    }
    public List<RespTransactionDto> mapToModelMapper(List<TransaksiTabungan> transaksiTabunganList) {
        return modelMapper.map(transaksiTabunganList,new TypeToken<List<RespTransactionDto>>(){
        }.getType());
    }
}
//    public Object save(ValTransactionDto valTransactionDto) {
//        Optional<User> userOpt = userRepository.findById(valTransactionDto.getUserId());
//        Optional<TargetTabungan> targetTabunganOpt = targetRepository.findById(valTransactionDto.getTargetId());
//        if (userOpt.isEmpty()) {
//            return "User not found";
//        }
//        if (targetTabunganOpt.isEmpty()) {
//            return "Target Tabungan not found";
//        }
//        TransaksiTabungan transaksiTabungan = mapToModel(valTransactionDto);
//        transaksiTabungan.setUser(userOpt.get());
//        transaksiTabungan.setTargetTabungan(targetTabunganOpt.get());
//        transactionRepository.save(transaksiTabungan);
//        return "Data berhasil disimpan";
//    }
//    public List<TransaksiTabungan> findAll() {
//        return transactionRepository.findAll();
//    }
//
//    public Optional<TransaksiTabungan> findById(Long id) {
//        return transactionRepository.findById(id);
//    }
//    public TransaksiTabungan mapToModel(ValTransactionDto valTransactionDto) {
//        TransaksiTabungan transaction = new TransaksiTabungan();
//        transaction.setJenisTransaksi(valTransactionDto.getJenisTransaksi());
//        transaction.setJumlahTransaksi(valTransactionDto.getJumlahTransaksi());
//        transaction.setMetodePembayaran(valTransactionDto.getMetodePembayaran());
//        transaction.setStatusTransaksi(valTransactionDto.getStatusTransaksi());
//        transaction.setKeterangan(valTransactionDto.getKeterangan());
//        transaction.setReferensiPembayaran(valTransactionDto.getReferensiPembayaran());
//        transaction.setCreatedAt(valTransactionDto.getCreatedAt());
//        transaction.setUpdatedAt(valTransactionDto.getUpdatedAt());
//        return transaction;
//    }
//    public List<RespTransactionDto> mapToModelMapper(List<TransaksiTabungan> transaksiList) {
//        return modelMapper.map(transaksiList, new TypeToken<List<RespTransactionDto>>() {
//        }.getType());
//    }
