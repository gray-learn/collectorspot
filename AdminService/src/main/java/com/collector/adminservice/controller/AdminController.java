package com.collector.adminservice.controller;

import com.collector.adminservice.dto.OrderDto;
import com.collector.adminservice.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(AdminController.class);
    StreamBridge streamBridge;
    public AdminController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestBody ProductDto pdto){
        logger.info("Sending request to Product Server");
        streamBridge.send("admin-out-1", new ProductDto("deleteproduct", pdto.id()));
        logger.info("Delete product success!!!");
        return  "Success";
    }
    @GetMapping("/getAllProduct")
    public String getAllProduct(){
        logger.info("Sending request to Product Server");
        streamBridge.send("admin-out-0", new ProductDto("all-product", 1));
        logger.info("Get All Product success!!!");
        return  "Success";
    }
    @PostMapping("/updateOrder")
    public String updateOrder(@RequestBody OrderDto odto){
        logger.info("Sending request to Order Server");
        streamBridge.send("admin-out-2", new OrderDto("updateorder", odto.id(),odto.total_price()));
        logger.info("Update order success!!!");
        return  "Success";
    }


}
