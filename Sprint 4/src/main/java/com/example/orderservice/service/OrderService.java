package main.java.com.example.orderservice.service;

import main.java.com.example.orderservice.dto.CreateOrderRequest;
import main.java.com.example.orderservice.dto.OrderResponse;
import main.java.com.example.orderservice.dto.UpdateOrderStatusRequest;
import main.java.com.example.orderservice.model.Order;
import main.java.com.example.orderservice.model.OrderStatus;
import main.java.com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setOriginAddress(request.getOriginAddress());
        order.setDestinationAddress(request.getDestinationAddress());
        order.setWeightKg(request.getWeightKg());
        order.setPackageDescription(request.getPackageDescription());
        order.setStatus(OrderStatus.CREATED);

        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return toResponse(order);
    }

    public List<OrderResponse> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse updateStatus(Long id, UpdateOrderStatusRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(request.getStatus());
        Order saved = orderRepository.save(order);
        return toResponse(saved);
    }

    private OrderResponse toResponse(Order order) {
        OrderResponse resp = new OrderResponse();
        resp.setId(order.getId());
        resp.setCustomerId(order.getCustomerId());
        resp.setOriginAddress(order.getOriginAddress());
        resp.setDestinationAddress(order.getDestinationAddress());
        resp.setWeightKg(order.getWeightKg());
        resp.setPackageDescription(order.getPackageDescription());
        resp.setStatus(order.getStatus());
        resp.setCreatedAt(order.getCreatedAt());
        resp.setUpdatedAt(order.getUpdatedAt());
        return resp;
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
