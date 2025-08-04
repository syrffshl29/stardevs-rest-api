package com.starcodes.tabungin.service;


import com.starcodes.tabungin.dto.response.RespDepositoDto;
import com.starcodes.tabungin.dto.response.RespTransactionDto;
import com.starcodes.tabungin.dto.validation.ValDepositoDto;
import com.starcodes.tabungin.model.Setoran;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.model.User;
import com.starcodes.tabungin.repository.DepositRepository;
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
public class DepositServiceImpl {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TargetRepository targetRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public Object save(ValDepositoDto valDepositoDto) {
        Optional<User> userOpt = userRepository.findById(valDepositoDto.getUserId());
        Optional<TargetTabungan> targetTabunganOpt = targetRepository.findById(valDepositoDto.getTargetId());
        Optional<TransaksiTabungan> transaksiTabunganOpt = transactionRepository.findById(valDepositoDto.getTransaksiId());
        
        if (userOpt.isEmpty()) {
            return "User not found";
        }
        if (targetTabunganOpt.isEmpty()) {
            return "Target Tabungan not found";
        }
        if (transaksiTabunganOpt.isEmpty()) {
            return "Transaksi Tabungan not found";
        }
        Setoran setoran = mapToModel(valDepositoDto);
        setoran.setUser(userOpt.get());
        setoran.setTargetTabungan(targetTabunganOpt.get());
        setoran.setTransaksiTabungan(transaksiTabunganOpt.get());
        depositRepository.save(setoran);
        return "Data berhasil disimpan";
    }
    public List<Setoran> findAll() {
        return depositRepository.findAll();
    }

    public Optional<Setoran> findById(Long id) {
        return depositRepository.findById(id);
    }
    public Setoran mapToModel(ValDepositoDto valDepositoDto) {
        Setoran setoran = new Setoran();
        setoran.setCatatanSetoran(valDepositoDto.getCatatanSetoran());
        setoran.setBuktiSetoran(valDepositoDto.getBuktiSetoran());
        setoran.setSumberDana(valDepositoDto.getSumberDana());
        setoran.setStatusVerifikasi(valDepositoDto.getStatusVerifikasi());
        setoran.setJumlahSetoran(valDepositoDto.getJumlahSetoran());
        setoran.setCreatedAt(valDepositoDto.getCreatedAt());
        setoran.setUpdatedAt(valDepositoDto.getUpdatedAt());
        return setoran;
    }
    public List<RespDepositoDto> mapToModelMapper(List<Setoran> setoranList) {
        return modelMapper.map(setoranList, new TypeToken<List<RespTransactionDto>>() {
        }.getType());
    }
}