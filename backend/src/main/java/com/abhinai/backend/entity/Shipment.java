package com.abhinai.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
//@Table(name = "shipments")
public class Shipment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer Name Cannot be empty")
    private String customerName;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    public Shipment(){
    }

    public Shipment(Long id, String customerName,String address,
                    String status){
        this.id =id;
        this.customerName = customerName;
        this.address = address;
        this.status = status;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id  = id;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName= customerName;
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
        this.status = status;
    }
}
