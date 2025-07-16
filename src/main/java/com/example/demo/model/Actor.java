package com.example.demo.model;
import java.util.List;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActors;

    // геттеры, сеттеры, конструкторы
}
