package com.collector.orderservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("game")
public class BookingController {
    // TODO

    Logger logger = LoggerFactory.getLogger(BookingController.class);
    StreamBridge streamBridge;

    public BookingController(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public String placeOrder(@RequestBody BookingDto orderDto){
        logger.info("Order received: " + orderDto.productName());
        logger.info("Sending request to Order Processing Service");
        streamBridge.send("process Order-out-0", orderDto);
        return  "Order placed successfully";
    }
}
