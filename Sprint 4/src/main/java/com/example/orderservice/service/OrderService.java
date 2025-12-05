package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderStatus;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order create(String origin, String destination) {
        Order o = new Order();
        o.setOrigin(origin);
        o.setDestination(destination);
        o.setStatus(OrderStatus.CREATED);
        return repo.save(o);
    }

    public Order get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Order updateStatus(Long id, OrderStatus status) {
        Order o = get(id);
        o.setStatus(status);
        return repo.save(o);
    }
}
