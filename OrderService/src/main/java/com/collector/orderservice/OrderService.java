package com.collector.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final CartRepository cartRepository;
    @Autowired
    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
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
        Order order = new Order(null, cart.getItemId(), 192.48, "Processed");
        return orderRepository.save(order);
    }
}
