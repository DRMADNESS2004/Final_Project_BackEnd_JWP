package com.example.finalproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private int population;
}
