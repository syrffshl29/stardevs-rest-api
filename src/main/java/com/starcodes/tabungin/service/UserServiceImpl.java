package com.starcodes.tabungin.service;

import com.starcodes.tabungin.core.interfaces.IService;
import com.starcodes.tabungin.dto.validation.ValUserDto;
import com.starcodes.tabungin.dto.response.RespUserDto;
import com.starcodes.tabungin.handler.ResponseHandler;
import com.starcodes.tabungin.model.User;
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

@Service
@Transactional
public class UserServiceImpl implements IService<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Object> save(User user, HttpServletRequest request) {
        if(user==null){
            return new ResponseHandler().handleResponse("Object Null", HttpStatus.BAD_REQUEST,null,"TRN01FV",request);
        }
        try {
            userRepository.save(user);
        }catch (Exception e){
            return new ResponseHandler().handleResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR,null,"TRN01FE01",request);
        }
        return new ResponseHandler().handleResponse("Data Berhasil Disimpan", HttpStatus.CREATED,null,null,request);
    }
    @Override
    public ResponseEntity<Object> delete(Long id, User user, HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity<Object> update(Long id, User user, HttpServletRequest request) {
        return null;
    }
    @Override
    public ResponseEntity<Object> findById(Long id, User user, HttpServletRequest request) {
        return userRepository.findById(id)
                .map(data -> {
                    RespUserDto dto = modelMapper.map(data, RespUserDto.class);
                    return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, dto, null, request);
                })
                .orElseGet(() -> new ResponseHandler().handleResponse("Data Tidak Ditemukan", HttpStatus.NOT_FOUND, null, "TRN01FI", request));
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        try {
            List<User> userList = userRepository.findAll();
            List<RespUserDto> respList = mapToModelMapper(userList);
            return new ResponseHandler().handleResponse("Data Ditemukan", HttpStatus.OK, respList, null, request);
        } catch (Exception e) {
            return new ResponseHandler().handleResponse("Gagal Mengambil Data", HttpStatus.INTERNAL_SERVER_ERROR, null, "TRN01FA", request);
        }
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, String column, String value, HttpServletRequest request) {
        return null;
    }
    public User mapToModelMapper(ValUserDto valUserDto) {
        return modelMapper.map(valUserDto, User.class);
    }

    public List<RespUserDto> mapToModelMapper(List<User> userList) {
        return modelMapper.map(userList, new TypeToken<List<RespUserDto>>() {
        }.getType());
    }
}
/** Mapping dto manual dalam bentuk object*/
    /*     public User mapToModel(ValUserDto valUserDto) {
           User user = new User();
           user.setName(valUserDto.getName());
           user.setUsername(valUserDto.getUsername());
           user.setPassword(valUserDto.getPassword());
           return user;
    *\     }

            /**Mapping dto manual dalam bentuk response*/
    /*
      public List<RespUserDto> mapToModel(List<User> user) {
      List<RespUserDto> list = new ArrayList<RespUserDto>();
      for (User user : userList){
      RespUserDto respUserDto = new ResplUserDto()
      respUserDto.setId(user.getId());
      respUserDto.setName(user.getName());
      respUserDto.setPassword(user.getPassword());
      list.add(respUserDto);
      public List<User> findAll() {
      return userRepo.findAll();
    }
    */