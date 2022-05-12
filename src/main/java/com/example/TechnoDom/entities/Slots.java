package com.example.TechnoDom.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "slots")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "isAvailable")
    private Boolean isAvailable;

    @OneToOne(fetch = FetchType.EAGER)
    private Cities city;

    @Column(name = "countOfOccupants")
    private Integer count;


}
