package com.collector.imageservice.publisher;

import com.collector.imageservice.config.MessagingConfig;
import com.collector.imageservice.dto.Order;
import com.collector.imageservice.dto.OrderStatus;
import com.collector.imageservice.service.StorageService;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import org.springframework.amqp.core.Message;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private StorageService service;

    @Autowired
    private RabbitTemplate template;
    @PostMapping("/{toyname}")
    public String bookOrder(@RequestBody Order order, @PathVariable String toyname) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + toyname);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }

    @GetMapping("/download/{fileName}")
    public String downloadFile(@PathVariable String fileName) {
        byte[] fileData = service.downloadFile(fileName);
        // TODO
        String fileType  =  ""; // get file type from file
        Message message = MessageBuilder.withBody(fileData).setHeader("ContentType", fileType).build();
        template.send(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, message);
        return "Success !!";
    }
}