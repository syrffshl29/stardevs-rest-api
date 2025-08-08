package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.response.RespDetailTargetDto;
import com.starcodes.tabungin.dto.validation.ValDetailTargetDto;
import com.starcodes.tabungin.model.DetailTarget;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.DetailTargetRepository;
import com.starcodes.tabungin.repository.TargetRepository;
import com.starcodes.tabungin.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailTargetServiceImpl {

    @Autowired
    private DetailTargetRepository detailTargetRepository;

    @Autowired
    private TargetRepository targetRepository;


    @Autowired
    private ModelMapper modelMapper;

    public Object save(ValDetailTargetDto valDetailTargetDto) {
        Optional<TargetTabungan> targetTabunganOpt = targetRepository.findById(valDetailTargetDto.getTargetId());
        if (targetTabunganOpt.isEmpty()) {
            return "Target Tabungan not Found";
        }

        DetailTarget detailTarget = mapToModel(valDetailTargetDto);
        detailTarget.setId(targetTabunganOpt.get().getId());
        detailTarget.setTargetId(targetTabunganOpt.get().getId());
        detailTarget.setStrategiMenabung(valDetailTargetDto.getStrategiMenabung());
        detailTarget.setTargetHarian(valDetailTargetDto.getTargetHarian());
        detailTarget.setTargetMingguan(valDetailTargetDto.getTargetMingguan());
        detailTarget.setCatatan(valDetailTargetDto.getCatatan());
        detailTarget.setCreatedAt(LocalDateTime.now());
        detailTarget.setUpdatedAt(LocalDateTime.now());
        detailTargetRepository.save(detailTarget);
        return "Data Berhasil Disimpan";
    }

    public DetailTarget mapToModel(ValDetailTargetDto valDetailTargetDto) {
        DetailTarget detailTarget = new DetailTarget();
        detailTarget.setId(valDetailTargetDto.getId());
        detailTarget.setTargetId(valDetailTargetDto.getTargetId());
        detailTarget.setTargetHarian(valDetailTargetDto.getTargetHarian());
        detailTarget.setTargetMingguan(valDetailTargetDto.getTargetMingguan());
        detailTarget.setCatatan(valDetailTargetDto.getCatatan());
        detailTarget.setCreatedAt(LocalDateTime.now());
        detailTarget.setUpdatedAt(LocalDateTime.now());
        return detailTarget;
    }

    public List<DetailTarget> findAll(){
        return detailTargetRepository.findAll();
    }

    public Optional<DetailTarget> findById(Long id) {
        return detailTargetRepository.findById(id);
    }

    public RespDetailTargetDto update(Long id, ValDetailTargetDto valDetailTargetDto) {

        DetailTarget detailTarget = detailTargetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetailTarget not found"));


        TargetTabungan targetTabungan = targetRepository.findById(valDetailTargetDto.getTargetId())
                .orElseThrow(() -> new RuntimeException("TargetTabungan not found"));


        detailTarget.setId(valDetailTargetDto.getId());
        detailTarget.setTargetId(valDetailTargetDto.getTargetId());
        detailTarget.setTargetHarian(valDetailTargetDto.getTargetHarian());
        detailTarget.setTargetMingguan(valDetailTargetDto.getTargetMingguan());
        detailTarget.setCatatan(valDetailTargetDto.getCatatan());
        detailTarget.setUpdatedAt(LocalDateTime.now());


        DetailTarget updated = detailTargetRepository.save(detailTarget);


        RespDetailTargetDto responseDetail = new RespDetailTargetDto();
        responseDetail.setId(updated.getId());
        responseDetail.setTargetId(valDetailTargetDto.getTargetId());
        responseDetail.setTargetHarian(valDetailTargetDto.getTargetHarian());
        responseDetail.setTargetMingguan(valDetailTargetDto.getTargetMingguan());
        responseDetail.setCatatan(valDetailTargetDto.getCatatan());
        responseDetail.setUpdatedAt(LocalDateTime.now());


        return responseDetail;
    }
}
