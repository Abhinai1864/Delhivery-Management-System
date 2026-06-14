package com.abhinai.backend.service;

import com.abhinai.backend.entity.Delivery;
import com.abhinai.backend.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository repository;

    public Delivery saveDelivery(Delivery delivery){
        return repository.save(delivery);
    }

    public List<Delivery> getAllDeliveries(){
        return repository.findAll();
    }

    public Delivery getDeliveryById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Delivery updateDelivery(Long id,Delivery updateDelivery){
        Delivery delivery = repository.findById(id).orElse(null);
        if(delivery != null){
            delivery.setCustomerName(updateDelivery.getCustomerName());
            delivery.setAddress(updateDelivery.getAddress());
            delivery.setStatus(updateDelivery.getStatus());

            return repository.save(delivery);
        }
        return null;
    }

    public void deleteDelivery(Long id){
        repository.deleteById(id);
    }
}
