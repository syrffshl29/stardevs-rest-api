package com.starcodes.tabungin.service;


import com.starcodes.tabungin.core.interfaces.IService;
import com.starcodes.tabungin.dto.response.RespDepositoDto;
import com.starcodes.tabungin.dto.response.RespTransactionDto;
import com.starcodes.tabungin.dto.validation.ValDepositoDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.Setoran;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.DepositRepository;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.TransactionRepository;
import com.starcodes.tabungin.repository.UserRepository;
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
import java.util.Optional;

@Service
@Transactional
public class DepositServiceImpl implements IService<Setoran> {

    @Autowired
    private DepositRepository depositRepository;

    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> save(Setoran setoran, HttpServletRequest request) {
        if(setoran==null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST,null,"TRN01FV",request);
        }
        try {
            depositRepository.save(setoran);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"TRN01FE01",request);
        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, Setoran setoran, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> update(Long id, Setoran setoran, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id, Setoran setoran, HttpServletRequest request) {
        return depositRepository.findById(id)
                .map(data ->{
                    RespDepositoDto dto = modelMapper.map(data, RespDepositoDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(()-> new ResponseHandler().handleResponse("Data Tidak Ditemukan",HttpStatus.NOT_FOUND,null,null,request));
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try{
            List<Setoran> setoranList = depositRepository.findAll();
            List<RespDepositoDto> respList = mapToModelMapper(setoranList);
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, respList, null, request);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return null;
    }
    public Setoran mapToModelMapper(ValDepositoDto valDepositoDto){
        return modelMapper.map(valDepositoDto, Setoran.class);
    }
    public List<RespDepositoDto>mapToModelMapper(List<Setoran> setoranList){
        return modelMapper.map(setoranList,new TypeToken<List<RespDepositoDto>>(){
        }.getType());
    }
}