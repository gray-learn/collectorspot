package com.collector.productservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameCollectorRepository extends JpaRepository<GameCollectorItem, Long> {
    GameCollectorItem findByName(String name);
}
