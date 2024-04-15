package com.collector.productservice.kafka;

import com.collector.productservice.ProductDto;
import com.collector.productservice.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionConfiguration {
    private final Logger logger =  LoggerFactory.getLogger(FunctionConfiguration.class);
    @Autowired
    private ProductService productService;

    @Bean
    Function<ProductDto, Boolean> product(){
        return (ProductDto dto)->{
            if(dto.type().equals("deleteproduct")){
                logger.info("Delete the product by id  " + dto.id());
                long pId = (long)dto.id();
                productService.processProductImageId(pId);
                productService.deleteProduct(pId);
            }
            return true;
        };
    }
}
