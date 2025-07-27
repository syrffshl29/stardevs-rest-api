package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.TargetTabunganDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.Users;
import com.starcodes.tabungin.repository.TargetRepository;
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
public class TargetServiceImpl {

	//implementasi dari TargetService
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Object save(TargetTabunganDto targetTabunganDto) {
        Optional<Users> userOpt = userRepository.findById(targetTabunganDto.getUserId());
        if (userOpt.isEmpty()){
        return "user not found";
        }
        TargetTabungan targetTabungan = mapToModel(targetTabunganDto);
        targetTabungan.setUser(userOpt.get());
        targetRepository.save(targetTabungan);
        return "Data Berhasil Disimpan";
    }

    public Object findAll() {
    List<TargetTabungan> targetTabunganList = targetRepository.findAll();
        return mapToModelMapper(targetTabunganList);
    }

    public Optional<TargetTabungan> findById(Long id) {
        return targetRepository.findById(id);
    }
    public TargetTabungan mapToModel (TargetTabunganDto targetTabunganDto) {
        TargetTabungan targetTabungan = new TargetTabungan();
        targetTabungan.setTargetName(targetTabunganDto.getTargetName());
        targetTabungan.setJumlahDataTarget(targetTabunganDto.getJumlahDataTarget());
        targetTabungan.setDeskripsi(targetTabunganDto.getDeskripsi());
        targetTabungan.setUserId(targetTabunganDto.getUserId());;
        targetTabungan.setSaldoTerkumpul(targetTabunganDto.getSaldoTerkumpul());
        return targetTabungan;

    }
        private Object mapToModelMapper(List<TargetTabungan> targetTabunganList) {
        return modelMapper.map(targetTabunganList, new TypeToken<List<TargetTabunganDto>>() {
        }.getType());
        }
}
