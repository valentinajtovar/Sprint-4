package main.java.com.example.orderservice.repository;


import main.java.com.example.orderservice.model.Order;
import main.java.com.example.orderservice.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);
}
