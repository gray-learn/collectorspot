package com.collector.productservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionConfiguration {
    private final Logger logger =
            LoggerFactory.getLogger(FunctionConfiguration.class);

    @Bean
    Function<EmailDto, Boolean> email(){
        return (EmailDto emaildto)->{
            logger.info("Sending Email to email address " + emaildto.email());
            return true;
        };
    }

}
