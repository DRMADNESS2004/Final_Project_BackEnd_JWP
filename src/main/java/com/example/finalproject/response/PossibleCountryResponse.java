package com.example.finalproject.response;

import com.example.finalproject.entity.PossibleCountry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PossibleCountryResponse {
    private String country;
    private int population;

    public PossibleCountryResponse(PossibleCountry possibleCountry){
        country=possibleCountry.getCountry();
        population=possibleCountry.getPopulation();
    }
}
