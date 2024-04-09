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
            GameCollectorItem item1 = new GameCollectorItem(1L, "The Legend of Zelda", "ZELDA123", "Available", 5, 145.99);
            GameCollectorItem item2 = new GameCollectorItem(2L, "Super Mario Bros.", "MARIO456", "Available", 3, 214.99);
            GameCollectorItem item3 = new GameCollectorItem(3L, "Final Fantasy VII", "FFVII789", "Available", 4, 150.99);
            GameCollectorItem item4 = new GameCollectorItem(4L, "Metal Gear Solid", "MGS101", "Available", 5, 200.99);
            GameCollectorItem item5 = new GameCollectorItem(5L, "Chrono Trigger", "CHRONO202", "Available", 2, 189.99);
            GameCollectorItem item6 = new GameCollectorItem(6L, "Resident Evil 2", "RE2303", "Available", 3, 240.99);
            GameCollectorItem item7 = new GameCollectorItem(7L, "Castlevania: Symphony of the Night", "CVSOTN404", "Available", 6, 345.99);
            GameCollectorItem item8 = new GameCollectorItem(8L, "Street Fighter II", "SFII505", "Available", 6, 188.99);
            GameCollectorItem item9 = new GameCollectorItem(9L, "Mega Man X", "MEGAMAN606", "Available", 2, 208.99);
            GameCollectorItem item10 = new GameCollectorItem(10L, "EarthBound", "EARTH707", "Available", 4, 158.99);


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


