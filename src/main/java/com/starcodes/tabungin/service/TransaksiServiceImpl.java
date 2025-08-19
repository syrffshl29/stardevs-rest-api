package com.starcodes.tabungin.service;

import com.starcodes.tabungin.core.interfaces.TransaksiTabunganService;
import com.starcodes.tabungin.dto.response.RespTransaksiTabunganDto;
import com.starcodes.tabungin.dto.validation.ValTransaksiTabunganDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.TransaksiTabungan;
import com.starcodes.tabungin.repository.TransaksiRepository;
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
public class TransaksiServiceImpl implements TransaksiTabunganService<TransaksiTabungan> {

    @Autowired
    private TransaksiRepository transaksiRepository;

    @Autowired
    private ModelMapper modelMapper;

    /** ===== Implementasi interface ===== */
    @Override
    public ResponseEntity<Object> save(TransaksiTabungan transaksi, HttpServletRequest request) {
        if(transaksi == null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST, null, "TRN01FV", request);
        }
        try{
            transaksiRepository.save(transaksi);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FE01", request);
        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED, null, null, request);
    }

    @Override
    public ResponseEntity<Object> delete(Long id, TransaksiTabungan obj, HttpServletRequest request) {
        try {
            transaksiRepository.deleteById(id);
            return new ResponseHandler().handleResponse("Data Berhasil Dihapus", HttpStatus.OK, null, null, request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Gagal Menghapus Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FD", request);
        }
    }

    @Override
    public ResponseEntity<Object> update(Long id, TransaksiTabungan obj, HttpServletRequest request) {
        try {
            return transaksiRepository.findById(id).map(existing -> {
                existing.setJenisTransaksi(obj.getJenisTransaksi());
                existing.setJumlahTransaksi(obj.getJumlahTransaksi());
                existing.setMetodePembayaran(obj.getMetodePembayaran());
                existing.setStatusTransaksi(obj.getStatusTransaksi());
                existing.setKeterangan(obj.getKeterangan());
                existing.setReferensiPembayaran(obj.getReferensiPembayaran());
                transaksiRepository.save(existing);
                return new ResponseHandler().handleResponse("Data Berhasil Diupdate", HttpStatus.OK, null, null, request);
            }).orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, null, request));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FE02", request);
        }
    }

    @Override
    public ResponseEntity<Object> findById(Long id, TransaksiTabungan obj, HttpServletRequest request) {
        return transaksiRepository.findById(id)
                .map(data -> {
                    RespTransaksiTabunganDto dto = modelMapper.map(data, RespTransaksiTabunganDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, null, request));
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try {
            List<TransaksiTabungan> list = transaksiRepository.findAll();
            List<RespTransaksiTabunganDto> dtoList = mapToDto(list);
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dtoList, null, request);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return null; // Bisa diimplementasikan jika perlu search
    }

    /** ===== Helper tambahan untuk DTO ===== */

    // Map DTO → Entity

    public TransaksiTabungan mapToEntity(ValTransaksiTabunganDto valTransaksiTabunganDto){
        return modelMapper.map(valTransaksiTabunganDto, TransaksiTabungan.class);
    }

    // Map List<Entity> → List<ResponseDTO>
    public List<RespTransaksiTabunganDto> mapToDto(List<TransaksiTabungan> transaksiList){
        return modelMapper.map(transaksiList, new TypeToken<List<RespTransaksiTabunganDto>>() {}.getType());
    }

    // Overload save yang menerima ValTransactionDto
    public ResponseEntity<Object> save(ValTransaksiTabunganDto valTransaksiTabunganDto, HttpServletRequest request){
        TransaksiTabungan transaksi = mapToEntity(valTransaksiTabunganDto);
        return save(transaksi, request);
    }
    @Override
    public ResponseEntity<Object> findByTargetId(Long targetId, HttpServletRequest request) {
        try {
            List<TransaksiTabungan> transaksiList = transaksiRepository.findByTargetTabunganId(targetId);

            if (transaksiList.isEmpty()) {
                return new ResponseHandler().handleResponse(
                        "Tidak ada transaksi untuk target ini",
                        HttpStatus.OK,
                        List.of(), // kosong
                        null,
                        request
                );
            }

            List<RespTransaksiTabunganDto> dtoList = mapToDto(transaksiList);

            return new ResponseHandler().handleResponse(
                    "Data transaksi ditemukan",
                    HttpStatus.OK,
                    dtoList,
                    null,
                    request
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseHandler().handleResponse(
                    "Gagal mengambil data transaksi",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null,
                    "TRN01FT",
                    request
            );
        }
    }
    public List<RespTransaksiTabunganDto> getListByTargetId(Long targetId) {
        List<TransaksiTabungan> transaksiList = transaksiRepository.findByTargetTabunganId(targetId);
        return mapToDto(transaksiList); // map langsung ke DTO
    }

}
