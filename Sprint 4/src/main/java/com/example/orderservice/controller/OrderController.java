package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderStatus;
import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestParam String origin,
                        @RequestParam String destination) {
        return service.create(origin, destination);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.get(id);
    }

    @PatchMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestParam OrderStatus status) {
        return service.updateStatus(id, status);
    }
}
