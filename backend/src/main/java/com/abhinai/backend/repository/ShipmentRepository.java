package com.abhinai.backend.repository;

import com.abhinai.backend.entity.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Page<Shipment> findByCustomerNameContainingIgnoreCase(
            String customerName,
            Pageable pageable
    );
}