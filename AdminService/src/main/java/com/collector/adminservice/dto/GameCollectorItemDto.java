package com.collector.adminservice.dto;

public record GameCollectorItemDto(Long id, String name, String description,
                                   Double price,
                                   Integer stock,
                                   String imageId) {
}

