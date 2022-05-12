package com.example.TechnoDom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long itemsId;

    @Column(name = "name")
    private String ItemsName;

    @Column(name = "count")
    private Integer count;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Categories> categories;


}
