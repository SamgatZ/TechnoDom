package com.example.TechnoDom.entities;

import com.example.TechnoDom.SlotValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "busket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Busket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Items item;

    @OneToOne(fetch = FetchType.EAGER)
    private Slots slot;




}
