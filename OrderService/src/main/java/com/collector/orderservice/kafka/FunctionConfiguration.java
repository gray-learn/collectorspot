package com.collector.orderservice.kafka;

import com.collector.orderservice.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class FunctionConfiguration {
    private final Logger logger =  LoggerFactory.getLogger(FunctionConfiguration.class);

    @Bean
    Function<OrderDto, Boolean> order(){
        return (OrderDto dto)->{
            if(dto.type().equals("updateorder")){
                logger.info("Update the Order by id  " + dto.id());
            }
            return true;
        };
    }
}
