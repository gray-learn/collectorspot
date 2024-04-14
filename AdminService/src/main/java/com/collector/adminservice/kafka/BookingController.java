package com.collector.adminservice.kafka;

import com.collector.adminservice.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookingController {

    Logger logger = LoggerFactory.getLogger(BookingController.class);
    StreamBridge streamBridge;

    public BookingController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public String book(@RequestBody ProductDto dto){
        logger.info("Booking success!!!");
        logger.info("Sending request to Email Server");
        streamBridge.send("sendEmail-out-0", dto);
        return  "Success";
    }
}
