package com.collector.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRespository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(String status);
}
