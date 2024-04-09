package com.collector.orderservice;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public OrderService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    public Cart addToCart(Long itemId, int quantity) {
        Cart cart = new Cart(null, itemId, quantity);
        return cartRepository.save(cart);
    }

    public Order checkout(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Order order = new Order(null, cart.getItemId(), "Processed");
        return orderRepository.save(order);
    }
}
