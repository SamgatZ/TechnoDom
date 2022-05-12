package com.example.TechnoDom.services;

import com.example.TechnoDom.entities.Busket;
import com.example.TechnoDom.repositories.BusketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusketService {
    @Autowired
    BusketRepository busketRepository;

    public List<Busket> getItemsInBusket() {
        return busketRepository.findAll();
    }

}
