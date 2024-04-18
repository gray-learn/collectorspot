package com.collector.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

    @Bean
    public WebMvcAutoConfiguration corsConfigurer(){

        return new WebMvcAutoConfiguration(){
//            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("").allowedOrigins("http://localhost:4200/");
            }
        };
    }
}
