package com.example.TechnoDom;

import com.example.TechnoDom.entities.Slots;
import com.example.TechnoDom.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotValidator {
    @Autowired
    SlotRepository slotRepository;


}
