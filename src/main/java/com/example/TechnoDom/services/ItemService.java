package com.example.TechnoDom.services;

import com.example.TechnoDom.entities.Items;
import com.example.TechnoDom.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }
}
