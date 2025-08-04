package com.starcodes.tabungin.config;

import com.starcodes.tabungin.model.TargetTabungan;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;

import java.util.Random;

@Configuration
public class MainConfig {

    private final SortHandlerMethodArgumentResolverCustomizer sortHandlerMethodArgumentResolverCustomizer;

    public MainConfig(SortHandlerMethodArgumentResolverCustomizer sortHandlerMethodArgumentResolverCustomizer) {
        this.sortHandlerMethodArgumentResolverCustomizer = sortHandlerMethodArgumentResolverCustomizer;
    }

    @Bean
    public Random getRandom() {
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

//    public ModelMapper getModelMapper2() {
//        ModelMapper modelMapper2 = new ModelMapper();
//
//        modelMapper2.typeMap(TransaksiTabungan.class, TransaksiTabungan.class).addMappings(mapper -> {
//            mapper.map( src -> src.getUser().getId(), TransaksiTabungan::setUser);
//            mapper.map(src -> src.getUser().getUsername(), TransaksiTabungan::setUser);
//            mapper.map( src -> src.getTargetTabungan().getId(),TransaksiTabungan::setTargetTabungan);
//            mapper.map( src -> src.getTargetTabungan().getTargetName(),TransaksiTabungan::setTargetTabungan);
//        });
//        return modelMapper2;
//    }


