package com.collector.adminservice.controller;

import com.collector.adminservice.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);
    StreamBridge streamBridge;
    public AdminController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestBody ProductDto pdto){
        logger.info("Sending request to Product Server");
        streamBridge.send("admin-out-0", pdto);
        logger.info("Delete product success!!!");
        return  "Success";
    }
}
