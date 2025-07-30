package com.starcodes.tabungin.config;

import com.starcodes.tabungin.model.TargetTabungan;
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
            mapper.map(src -> src.getUser().getId(), TargetTabungan::setUser);
            mapper.map(src -> src.getUser().getUsername(), TargetTabungan::setUser);

        });
        return modelMapper;
    }

}
