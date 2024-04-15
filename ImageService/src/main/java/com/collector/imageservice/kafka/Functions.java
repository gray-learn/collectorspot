package com.collector.imageservice.kafka;

import com.collector.imageservice.dto.ImageDto;
import com.collector.imageservice.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class Functions {

    private final Logger logger =  LoggerFactory.getLogger(Functions.class);
    @Autowired
    private StorageService storageService;
    @Bean
    Function<ImageDto, Boolean> image(){
        return (ImageDto dto)->{
            logger.info("Delete the image by id  " + dto.name());
            if(storageService.isFileExist(dto.name())){
                storageService.deleteFile(dto.name());
            } else {
                logger.info("There is no image by id  " + dto.name());
            }
            return true;
        };
    }

}
