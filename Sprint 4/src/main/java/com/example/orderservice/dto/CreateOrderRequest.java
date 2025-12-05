package main.java.com.example.orderservice.dto;

public class CreateOrderRequest {

    private Long customerId;
    private String originAddress;
    private String destinationAddress;
    private Double weightKg;
    private String packageDescription;

    // Getters y setters
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getOriginAddress() {
        return originAddress;
    }
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
    public String getDestinationAddress() {
        return destinationAddress;
    }
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
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


}
