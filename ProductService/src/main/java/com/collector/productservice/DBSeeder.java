package com.collector.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EntityScan(basePackageClasses = {com.collector.productservice.GameCollectorItem.class})
@EnableJpaRepositories(basePackageClasses = {GameCollectorRepository.class})
public class DBSeeder {
    @Bean
    CommandLineRunner initDatabase(GameCollectorRepository repository) {
        return args -> {
            List<GameCollectorItem> list = new ArrayList<>();
            list.add(new GameCollectorItem(1L, "The Legend of Zelda", "ZELDA123", 145.99, 5, "1459"));
            list.add(new GameCollectorItem(2L, "Super Mario Bros.", "MARIO456", 214.99, 3, "2149"));
            list.add(new GameCollectorItem(3L, "Final Fantasy VII", "FFVII789", 150.99, 4, "1509"));
            list.add(new GameCollectorItem(4L, "Metal Gear Solid", "MGS101", 200.99, 5, "2009"));
            list.add(new GameCollectorItem(5L, "Chrono Trigger", "CHRONO202", 189.99, 2, "1899"));
            list.add(new GameCollectorItem(6L, "Resident Evil 2", "RE2303", 240.99, 3, "2409"));
            list.add(new GameCollectorItem(7L, "Castlevania: Symphony of the Night", "CVSOTN404", 345.99, 6, "3459"));
            list.add(new GameCollectorItem(8L, "Street Fighter II", "SFII505", 188.99, 6, "1889"));
            list.add(new GameCollectorItem(9L, "Mega Man X", "MEGAMAN606", 208.99, 2, "2089"));
            list.add(new GameCollectorItem(10L, "EarthBound", "EARTH707", 158.99, 4, "1589"));
            repository.saveAll(list);
        };
    }
}
