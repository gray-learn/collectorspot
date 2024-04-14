package com.collector.adminservice.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class Functions {

    @Bean
    public Consumer<Boolean> admin(){
        return (Boolean success)->{
            if(success) {
                System.out.println("The email was successful");
            }
        };
    }

}
