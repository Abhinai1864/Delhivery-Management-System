package com.abhinai.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Delivery Management System is running";
    }
}
