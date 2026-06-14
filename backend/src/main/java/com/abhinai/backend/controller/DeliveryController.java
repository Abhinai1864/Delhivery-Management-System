package com.abhinai.backend.controller;

import com.abhinai.backend.entity.Delivery;
import com.abhinai.backend.repository.DeliveryRepository;
import com.abhinai.backend.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @GetMapping("/api/hello")
    public String hello() {
        return "Delivery Management System is Running";
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return service.saveDelivery(delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return service.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(
            @PathVariable Long id,
            @RequestBody Delivery delivery){
        return service.updateDelivery(id, delivery);
    }

    @DeleteMapping("/{id}")
    public String deleteDelivery(@PathVariable Long id){
        service.deleteDelivery(id);
        return "Delivery Deleted Successfully";
    }
}