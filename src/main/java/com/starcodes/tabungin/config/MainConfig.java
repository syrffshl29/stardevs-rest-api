package com.starcodes.tabungin.config;

import com.starcodes.tabungin.model.DetailTarget;
import com.starcodes.tabungin.model.TargetTabungan;
import com.starcodes.tabungin.model.Users;
import com.starcodes.tabungin.model.TransaksiTabungan;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class MainConfig {

    @Bean
    public Random getRandom(){
        return new Random();
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(TargetTabungan.class, TargetTabungan.class).addMappings(mapper -> {
            mapper.map(src -> src.getUserId().getId(), TargetTabungan::setUserId);
            mapper.map(src -> src.getUserId().getUsername(), TargetTabungan::setUsername);

        });
        return modelMapper;
    }

}
