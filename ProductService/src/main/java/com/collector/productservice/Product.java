package com.collector.productservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "gamecollector")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //id(INT PRIMARY KEY)

    @Column(nullable = false, length = 255)
    private String name; //name(VARCHAR(255) NOT NULL)

    @Column(columnDefinition = "TEXT")
    private String description; //description(TEXT)

    @Column(nullable = false, precision = 10, scale = 2)
    private Double price; //price(DECIMAL(10,2) NOT NULL)

    @Column(nullable = false)
    private Integer stock; //stock(INT NOT NULL)

    @Column(nullable = false, length = 50)
    private String image_id; //image_id(VARCHAR(50) NOT NULL)
}
