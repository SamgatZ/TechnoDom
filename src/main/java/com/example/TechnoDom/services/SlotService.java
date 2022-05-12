package com.example.TechnoDom.services;

import com.example.TechnoDom.entities.Busket;
import com.example.TechnoDom.entities.Cities;
import com.example.TechnoDom.entities.Slots;
import com.example.TechnoDom.repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class SlotService {
    @Autowired
    SlotRepository slotRepository;

    public Hashtable<LocalDate,ArrayList<Slots>> listSlotsByCity(String cityName) {
        Hashtable<LocalDate,ArrayList<Slots>> slots = new Hashtable<>();
        List<Slots> slotsList =  slotRepository.findSlotsByCity_Name(cityName);
        for (int i = 0; i < slotsList.size(); i++) {
            if (slots.containsKey(slotsList.get(i).getDate())) {
                slots.get(slotsList.get(i).getDate()).add(slotsList.get(i));
            } else {
                ArrayList<Slots> arrayList = new ArrayList<>();
                arrayList.add(slotsList.get(i));
                slots.put(slotsList.get(i).getDate(),arrayList);
            }
        }
        return slots;
    }

    public List<Slots> getAvailableSlots(String city,LocalDate date) {
        Hashtable<LocalDate,ArrayList<Slots>> slots = new Hashtable<>();
        slots = listSlotsByCity(city);
        List<Slots> slotsList = slots.get(date);
        for (int i = 0; i < slotsList.size(); i++) {
            if (!slotsList.get(i).getIsAvailable()) slots.remove(slotsList.get(i));
        }
        return slotsList;
    }

    public void bookSlot(String city, LocalDate date, Busket busket) {
        List<Slots> slots = getAvailableSlots(city,date);
        if(slots.size()!=0) {
            Comparator<Slots> slotsComparator = new Comparator<Slots>() {
                @Override
                public int compare(Slots o1, Slots o2) {
                    if (Integer.parseInt(o1.getEnd()) < Integer.parseInt(o2.getEnd())) {
                        return 1;
                    }

                    if (Integer.parseInt(o1.getEnd()) > Integer.parseInt(o2.getEnd())) {
                        return -1;
                    }
                    return 0;
                }
            };
            Stack<Slots> stack = new Stack<>();
            slots.sort(slotsComparator);
            for (Slots s:
                 slots) {
                if (s.getIsAvailable() == true) {
                    stack.push(s);
                }
            }

            stack.get(0).setCount(stack.get(0).getCount() + 1);
        } else {
            return;
        }

    }







}
