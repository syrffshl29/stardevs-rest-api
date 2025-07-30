package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.response.RespTargetTabunganDto;
import com.starcodes.tabungin.dto.validation.ValTargetTabunganDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.User;
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

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object save(ValTargetTabunganDto  valTargetTabunganDto) {
        Optional<User> userOpt = userRepository.findById(valTargetTabunganDto.getUserId());
        if (userOpt.isEmpty()) {
            return "User not found";
        }

        TargetTabungan targetTabungan = mapToModel(valTargetTabunganDto);
        targetTabungan.setUser(userOpt.get());

        targetRepository.save(targetTabungan);
        return "Data berhasil disimpan";
    }

    public Object findAll() {
        List<TargetTabungan> targetList = targetRepository.findAll();
        return mapToModelMapper(targetList);
    }

    public Optional<TargetTabungan> findById(Long id) {
        return targetRepository.findById(id);
    }

    public TargetTabungan mapToModel(ValTargetTabunganDto valTargetTabunganDto) {
        TargetTabungan target = new TargetTabungan();
        target.setTargetName(valTargetTabunganDto.getTargetName());
        target.setJumlahDataTarget(valTargetTabunganDto.getJumlahDataTarget());
        target.setTanggalMulaiTarget(valTargetTabunganDto.getTanggalMulaiTarget());
        target.setDeskripsi(valTargetTabunganDto.getDeskripsi());
        target.setSaldoTerkumpul(valTargetTabunganDto.getSaldoTerkumpul());
        target.setStatusTarget(valTargetTabunganDto.getStatusTarget());

        return target;
    }

    public List<RespTargetTabunganDto> mapToModelMapper(List<TargetTabungan> targetList) {
        return modelMapper.map(targetList, new TypeToken<List<RespTargetTabunganDto>>() {
        }.getType());
    }
}