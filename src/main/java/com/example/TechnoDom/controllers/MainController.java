package com.example.TechnoDom.controllers;

import com.example.TechnoDom.SlotValidator;
import com.example.TechnoDom.entities.Busket;
import com.example.TechnoDom.entities.Items;
import com.example.TechnoDom.entities.Slots;
import com.example.TechnoDom.services.BusketService;
import com.example.TechnoDom.services.ItemService;
import com.example.TechnoDom.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    @Autowired
    ItemService itemService;

    @Autowired
    SlotService slotService;

    @Autowired
    BusketService busketService;

    @GetMapping(value = "/")
    public List<Items> getALlItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/getALlSlots/{city}")
    public Hashtable<LocalDate, ArrayList<Slots>>  getSlots(@PathVariable(name = "city") String cityName) {
        return slotService.listSlotsByCity(cityName);
    }

    @GetMapping(value = "/getfreeslots/{city}/{date}")
    public List<Slots> getAvailableSlots(@PathVariable(name = "city") String city,
                                         @PathVariable(name = "date") String date) {
        LocalDate dt = LocalDate.parse(date);
        return slotService.getAvailableSlots(city,dt);
    }

    @GetMapping(value = "/busket")
    public List<Busket> busket() {
        return busketService.getItemsInBusket();
    }


    @PostMapping(value = "/buyItem")
    public ResponseEntity<?> buyItem(@RequestBody Items item) {


        return new ResponseEntity<>(busketService.getItemsInBusket(),HttpStatus.OK);
    }

}
