package com.abhinai.backend.controller;

import com.abhinai.backend.dto.ShipmentDTO;
import com.abhinai.backend.entity.Shipment;
import com.abhinai.backend.service.ShipmentService;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/shipments")
@CrossOrigin(origins = "http://localhost:5173")
public class ShipmentController {
        private final ShipmentService shipmentService;

        public ShipmentController(
                ShipmentService shipmentService) {
            this.shipmentService = shipmentService;
        }

        @Operation(summary = "Get all shipments")
        @GetMapping
        public List<Shipment> getAllShipments() {
            return shipmentService.getAllShipments();
        }

    @Operation(summary = "Create a new shipment")
    @PostMapping
    public Shipment createShipment(
            @Valid @RequestBody ShipmentDTO shipmentDTO) {

        Shipment shipment = new Shipment();

        shipment.setCustomerName(shipmentDTO.getCustomerName());
        shipment.setAddress(shipmentDTO.getAddress());
        shipment.setStatus(shipmentDTO.getStatus());

        return shipmentService.createShipment(shipment);
    }


    @Operation(summary = "Update an existing shipment")
    @PutMapping("/{id}")
    public Shipment updateShipment(
            @PathVariable Long id,
            @Valid @RequestBody ShipmentDTO shipmentDTO) {

        Shipment shipment = new Shipment();

        shipment.setCustomerName(shipmentDTO.getCustomerName());
        shipment.setAddress(shipmentDTO.getAddress());
        shipment.setStatus(shipmentDTO.getStatus());

        return shipmentService.updateShipment(id, shipment);
    }

    @Operation(summary = "Delete a shipment by ID")
    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }

    @Operation(summary = "Get shipment by ID")
    @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }
}
