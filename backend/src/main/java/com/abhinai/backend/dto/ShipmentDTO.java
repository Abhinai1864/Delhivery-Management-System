package com.abhinai.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ShipmentDTO {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Status is required")
    private String status;


    public ShipmentDTO() {
    }

    public ShipmentDTO(String customerName,
                       String address,
                       String status) {
        this.customerName = customerName;
        this.address = address;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status= status;
    }
}