package com.example.TechnoDom.repositories;

import com.example.TechnoDom.entities.Cities;
import com.example.TechnoDom.entities.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SlotRepository extends JpaRepository<Slots,Long> {
    public List<Slots> findSlotsByCity_Name(String city);
}
