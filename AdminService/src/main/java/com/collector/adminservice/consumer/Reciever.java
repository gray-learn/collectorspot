package com.collector.adminservice.consumer;

import com.collector.adminservice.config.MessagingConfig;
import com.collector.adminservice.dto.OrderStatus;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
public class Reciever {
//    @RabbitListener(queues = MessagingConfig.QUEUE)
//    public void consumeMessageFromQueue(OrderStatus orderStatus) {
//        System.out.println("Message recieved from queue : " + orderStatus);
//    }

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Message message) {
        // FILE
        byte[] messageBody = message.getBody();
        File file = new File("/Users/kourui/Downloads/bigbigbigminion.jpeg");
        try {
            OutputStream os = new FileOutputStream(file) ;
            os.write(messageBody);
            os.close();
            System.out.println("Message recieved from queue : " + message);
            System.out.println("write to file");
        } catch(Exception e){

        }

    }
}