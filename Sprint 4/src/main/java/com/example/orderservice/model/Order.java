package main.java.com.example.orderservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificador del cliente (puede ser de otro microservicio)
    private Long customerId;

    private String destinationAddress;
    private String originAddress;

    private Double weightKg;
    private String packageDescription;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor vacío requerido por JPA
    public Order() {
    }

    // Getters y setters...

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = OrderStatus.CREATED;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Getters y setters omitidos por brevedad

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getDestinationAddress() {
        return destinationAddress;
    }
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    public String getOriginAddress() {
        return originAddress;
    }
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
    public Double getWeightKg() {
        return weightKg;
    }
    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }
    public String getPackageDescription() {
        return packageDescription;
    }
    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    // Agrega este setter que falta:
public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}

// Y agrega el setter para createdAt si no lo tienes:
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

}
