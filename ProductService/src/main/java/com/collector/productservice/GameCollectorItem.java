package com.collector.productservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GameCollectorItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Represents the unique identifier for the record (INT PRIMARY KEY)
    private String name; // Represents the title of the game collector item (VARCHAR(255) NOT NULL)
    private String description; // Represents the SKU or description of the item (TEXT)
    private Double price; // Represents the price of the item (DECIMAL(10,2) NOT NULL)
    private Integer stock; // Represents the available quantity in stock (INT NOT NULL)
    private String imageId; // Represents the identifier for the associated image (VARCHAR(50) NOT NULL)

    public GameCollectorItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
