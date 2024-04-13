package com.collector.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.java.FloatPrimitiveArrayJavaType;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//id(INT PRIMARY KEY)
    private Long orderDate;//for the ID of the GameCollectorItem
    private Double totalPrice;//for the status of the order
    private String status;
    //order_date (DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP)
    //total_price (DECIMAL(10,2)NOT NULL)
    //(Foreign Key references Products.id for ordered products and their quantities)
}
