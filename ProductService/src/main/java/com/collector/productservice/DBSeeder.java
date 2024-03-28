package com.collector.productservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {com.collector.productservice.Book.class})
@EnableJpaRepositories(basePackageClasses = {com.collector.productservice.BookRespository.class})
public class DBSeeder {
    @Bean
    CommandLineRunner initDatabase(BookRespository repository) {
        return args -> {
            repository.save(new Book(0L, "How to Be Old: Lessons in Living Boldly from the Accidental Icon", "9780593471791","AVAILABLE"));
        };
    }
}


