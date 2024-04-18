package com.collector.adminservice.kafka;

import com.collector.adminservice.dto.GameCollectorItemDto;
import com.collector.adminservice.dto.OutputDto;
import com.collector.adminservice.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionConfiguration {
    private final Logger logger =  LoggerFactory.getLogger(FunctionConfiguration.class);

    StreamBridge streamBridge;

//    @Bean
//    public Consumer<Boolean> admin(){
//        return (Boolean success)->{
//            if(success) {
//                System.out.println("The email was successful");
//            }
//        };
//    }
    @Bean
    Function<OutputDto, Boolean> admin(){
        return (OutputDto dto)->{
            String type = dto.type();
            logger.info(type);
            if(type.equals("getallproduct")){
                for(GameCollectorItemDto pDto: dto.list()){
                    System.out.println(pDto);
                }
            } else if(type.equals("all-product")){
//                logger.info("Sending all product to admin Server");
//                streamBridge.send("product-out-4", productService.getAllProduct());
            }
            return true;
        };
    }

}
