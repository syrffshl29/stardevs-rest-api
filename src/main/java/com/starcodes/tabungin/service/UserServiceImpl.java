package com.starcodes.tabungin.service;

import com.starcodes.tabungin.dto.validation.ValUserDto;
import com.starcodes.tabungin.dto.response.RespUserDto;
import com.starcodes.tabungin.model.User;
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
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object save(User user) {
        userRepository.save(user);
        return "Data Berhasil Disimpan";
    }

    public Object findAll() {
        List<User> userList = userRepository.findAll();
        return mapToModelMapper(userList);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
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