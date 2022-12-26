package com.example.finalproject.entity;

import com.example.finalproject.request.PossibleCountryRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="possible_countries")
@Getter
@Setter
@NoArgsConstructor
public class PossibleCountry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private String country;
    @Column
    private int population;

    public PossibleCountry(PossibleCountryRequest possibleCountryRequest){
        country=possibleCountryRequest.getCountry();
        population=possibleCountryRequest.getPopulation();
    }
}
