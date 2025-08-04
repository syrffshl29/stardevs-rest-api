package com.starcodes.tabungin.service;

import com.starcodes.tabungin.core.interfaces.IService;
import com.starcodes.tabungin.dto.response.RespTargetTabunganDto;
import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.repository.TargetRepository;
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
public class TargetServiceImpl implements IService<TargetTabungan> {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> save(TargetTabungan targetTabungan, HttpServletRequest request) {
        if(targetTabungan==null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST,null,"TRN01FV",request);
        }
        try {
            targetRepository.save(targetTabungan);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"TRN01FE01",request);
        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED,null,null,request);
    }
    @Override
    public ResponseEntity<Object> delete(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity<Object> update(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity<Object> findById(Long id, TargetTabungan targetTabungan, HttpServletRequest request) {
        return targetRepository.findById(id)
                .map(data -> {
                    RespTargetTabunganDto dto = modelMapper.map(data, RespTargetTabunganDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FI", request));
    }
    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try {
            List<TargetTabungan> targetList = targetRepository.findAll();
            List<RespTargetTabunganDto> respList = mapToModelMapper(targetList);
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, respList, null, request);
        } catch (Exception e) {
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }
    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return null;
    }
    public TargetTabungan mapToModelMapper(ValTargetTabunganDto valTargetTabunganDto) {
        return modelMapper.map(valTargetTabunganDto, TargetTabungan.class);
    }
    public List<RespTargetTabunganDto> mapToModelMapper(List<TargetTabungan> targetList) {
        return modelMapper.map(targetList, new TypeToken<List<RespTargetTabunganDto>>() {
        }.getType());
    }
}