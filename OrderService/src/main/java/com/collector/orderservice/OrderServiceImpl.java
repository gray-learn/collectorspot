package com.collector.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl{
//    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final OrderRepository orderRepository;

    //@Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    //@Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    //@Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    //@Override
    public boolean existsById(Long id) {
        return orderRepository.existsById(id);
    }

    //@Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    public OrderServiceImpl(CartRepository cartRepository, OrderRepository orderRepository) {
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
