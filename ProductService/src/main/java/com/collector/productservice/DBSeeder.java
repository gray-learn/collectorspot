package com.collector.productservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {com.collector.productservice.GameCollectorItem.class})
@EnableJpaRepositories(basePackageClasses = {GameCollectorRepository.class})
public class DBSeeder {
    @Bean
    CommandLineRunner initDatabase(GameCollectorRepository repository) {
        return args -> {
            GameCollectorItem item1 = new GameCollectorItem(1L, "Game 1", "SKU1", "Available");
            GameCollectorItem item2 = new GameCollectorItem(2L, "Game 2", "SKU2", "Out of Stock");
            GameCollectorItem item3 = new GameCollectorItem(3L, "Game 3", "SKU3", "Available");
            GameCollectorItem item4 = new GameCollectorItem(4L, "Game 4", "SKU4", "Out of Stock");
            GameCollectorItem item5 = new GameCollectorItem(5L, "Game 5", "SKU5", "Available");
            GameCollectorItem item6 = new GameCollectorItem(6L, "Game 6", "SKU6", "Out of Stock");
            GameCollectorItem item7 = new GameCollectorItem(7L, "Game 7", "SKU7", "Available");
            GameCollectorItem item8 = new GameCollectorItem(8L, "Game 8", "SKU8", "Out of Stock");
            GameCollectorItem item9 = new GameCollectorItem(9L, "Game 9", "SKU9", "Available");
            GameCollectorItem item10 = new GameCollectorItem(10L, "Game 10", "SKU10", "Out of Stock");

            repository.save(item1);
            repository.save(item2);
            repository.save(item3);
            repository.save(item4);
            repository.save(item5);
            repository.save(item6);
            repository.save(item7);
            repository.save(item8);
            repository.save(item9);
            repository.save(item10);
        };
    }
}


