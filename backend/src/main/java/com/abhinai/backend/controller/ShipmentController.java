package com.abhinai.backend.controller;

import com.abhinai.backend.entity.Shipment;
import com.abhinai.backend.service.ShipmentService;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(
            ShipmentService shipmentService){
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public List<Shipment> getAllShipments(){
        return shipmentService.getAllShipments();
    }


    @PostMapping
    public Shipment createShipment(@Valid @RequestBody Shipment shipment) {
        return shipmentService.saveShipment(shipment);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(
            @PathVariable Long id,
            @RequestBody Shipment shipment){

        return shipmentService.updateShipment(id, shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id){
        shipmentService.deleteShipment(id);
    }

    @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable Long id){
        return shipmentService.getShipmentById(id);
    }
}
