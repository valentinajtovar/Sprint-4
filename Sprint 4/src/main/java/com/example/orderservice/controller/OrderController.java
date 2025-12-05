package main.java.com.example.orderservice.controller;

import main.java.com.example.orderservice.dto.CreateOrderRequest;
import main.java.com.example.orderservice.dto.OrderResponse;
import main.java.com.example.orderservice.dto.UpdateOrderStatusRequest;
import main.java.com.example.orderservice.model.OrderStatus;
import main.java.com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Crear una orden
    @PostMapping
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    // Obtener una orden por ID
    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    // Listar órdenes (todas o filtradas por estado)
    @GetMapping
    public List<OrderResponse> getOrders(
            @RequestParam(name = "status", required = false) OrderStatus status) {

        if (status == null) {
            // devolver todas
            return orderService.getAllOrders();
        }
        // devolver filtradas
        return orderService.getOrdersByStatus(status);
    }

    // Cambiar estado de una orden
    @PatchMapping("/{id}/status")
    public OrderResponse updateOrderStatus(
            @PathVariable Long id,
            @RequestBody UpdateOrderStatusRequest request) {

        return orderService.updateStatus(id, request);
    }
}