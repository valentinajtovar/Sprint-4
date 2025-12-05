package main.java.com.example.orderservice.dto;

import main.java.com.example.orderservice.model.OrderStatus;

public class UpdateOrderStatusRequest {

    private OrderStatus status;

    // Getters y setters
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
