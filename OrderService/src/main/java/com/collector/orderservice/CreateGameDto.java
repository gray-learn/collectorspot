package com.collector.orderservice;

public record CreateGameDto(
        int id,
        Long orderDate,
        double totalPrice
) {
    Order toOrder() {
        return Order.builder()
                //.id(id)
                .orderDate(orderDate)
                .totalPrice(totalPrice)
                .build();
    }
}
