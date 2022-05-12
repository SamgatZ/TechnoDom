package com.example.TechnoDom.repositories;

import com.example.TechnoDom.entities.Busket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BusketRepository extends JpaRepository<Busket,Long> {

}
