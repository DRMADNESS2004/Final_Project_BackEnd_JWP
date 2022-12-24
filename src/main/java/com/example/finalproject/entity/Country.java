package com.example.finalproject.entity;

import com.example.finalproject.request.CountryRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="countries")
@Getter
@Setter
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private int population;

    @Column(nullable=false)
    private boolean selected;

    public Country(CountryRequest countryRequest){
        name=countryRequest.getName();
        population=countryRequest.getPopulation();
        selected=countryRequest.getSelected();
    }
}
