package com.collector.productservice;

public record CreateProductDto(
        int id,
        String name,
        String description,
        double price,
        int stock,
        String image_id
) {
    Product toProduct() {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .stock(stock)
                .image_id(image_id)
                .build();
    }

    public GameCollectorItem toGameCollectorItem() {
        return null;
    }
}
