package com.collector.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<GameCollectorItem, Long> {
//    List<GameCollectorItem> findByStatus(String status);
}
