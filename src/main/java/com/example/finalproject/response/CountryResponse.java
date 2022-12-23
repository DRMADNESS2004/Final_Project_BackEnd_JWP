package com.example.finalproject.response;

import com.example.finalproject.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {
    private long id;
    private String name;
    private int population;
    private boolean selected;

    public CountryResponse(Country country){
        id=country.getId();
        name= country.getName();
        population= country.getPopulation();
        selected= country.isSelected();
    }
}
