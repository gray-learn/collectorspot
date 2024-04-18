package com.collector.productservice.kafka;

import com.collector.productservice.OutputDto;
import com.collector.productservice.ProductDto;
import com.collector.productservice.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionConfiguration {
    private final Logger logger =  LoggerFactory.getLogger(FunctionConfiguration.class);
    @Autowired
    private ProductService productService;
    StreamBridge streamBridge;
    public FunctionConfiguration(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @Bean
    Function<ProductDto, Boolean> product(){
        return (ProductDto dto)->{
            String type = dto.type();
            logger.info(type);
            if(type.equals("deleteproduct")){
                logger.info("Delete the product by id  " + dto.id());
                long pId = (long)dto.id();
                productService.processProductImageId(pId);
                productService.deleteProduct(pId);
            } else if(type.equals("all-product")){
                logger.info("Sending all product to admin Server");
                streamBridge.send("product-out-4", new OutputDto("getallproduct",productService.getAllProduct()));
            }
            return true;
        };
    }
}
