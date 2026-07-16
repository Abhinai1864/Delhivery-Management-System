package com.abhinai.backend.service;

import com.abhinai.backend.entity.Shipment;
import com.abhinai.backend.exception.ShipmentNotFoundException;
import com.abhinai.backend.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment saveShipment(Shipment shipment){
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments(){
        return shipmentRepository.findAll();
    }

    public Shipment updateShipment(Long id, Shipment shipment) {

        Shipment existingShipment = shipmentRepository
                .findById(id)
                .orElseThrow(() ->
                        new ShipmentNotFoundException(
                                "Shipment not found with id: " + id));

        existingShipment.setCustomerName(shipment.getCustomerName());
        existingShipment.setAddress(shipment.getAddress());
        existingShipment.setStatus(shipment.getStatus());

        return shipmentRepository.save(existingShipment);
    }

    public void deleteShipment(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ShipmentNotFoundException(
                                "Shipment not found with id: " + id));

        shipmentRepository.delete(shipment);
    }

    public Shipment getShipmentById(Long id) {

        return shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ShipmentNotFoundException(
                                "Shipment not found with id: " + id));
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}

