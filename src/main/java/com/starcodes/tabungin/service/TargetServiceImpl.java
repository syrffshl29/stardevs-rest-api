package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.TargetTabunganDto;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.Users;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TargetServiceImpl {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object save(TargetTabunganDto targetTabunganDto) {
        Optional<Users> userOpt = userRepository.findById(targetTabunganDto.getUserId());
        if (userOpt.isEmpty()) {
            return "User not found";
        }
        Users user = userOpt.get();
        TargetTabungan targetTabungan = mapToModel(targetTabunganDto, user);
        targetRepository.save(targetTabungan);
        return "Data berhasil disimpan";
    }

    public Object findAll() {
        List<TargetTabungan> targetTabunganList = targetRepository.findAll();
        return mapToDtoList(targetTabunganList);
    }

    public Optional<TargetTabungan> findById(Long id) {
        return targetRepository.findById(id);
    }

    private TargetTabungan mapToModel(TargetTabunganDto dto, Users user) {
        TargetTabungan target = new TargetTabungan();
        target.setTargetName(dto.getTargetName());
        target.setJumlahDataTarget(dto.getJumlahDataTarget());
        target.setDeskripsi(dto.getDeskripsi());
        target.setSaldoTerkumpul(dto.getSaldoTerkumpul());
        target.setUser(user);
        return target;
    }

    private List<TargetTabunganDto> mapToDtoList(List<TargetTabungan> entities) {
        return entities.stream().map(entity -> {
            TargetTabunganDto dto = modelMapper.map(entity, TargetTabunganDto.class);
            if (entity.getUser() != null) {
                dto.setUserId(entity.getUser().getId());
                dto.setUsername(entity.getUser().getUsername());
            }
            return dto;
        }).collect(Collectors.toList());
    }
}
