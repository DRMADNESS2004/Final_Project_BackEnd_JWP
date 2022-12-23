package com.example.finalproject.response;

import com.example.finalproject.entity.Citizen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitizenResponse {
    private long id;
    private String name;
    private CountryResponse country;

    public CitizenResponse(Citizen citizen){
        id=citizen.getId();
        name=citizen.getName();
        country=new CountryResponse(citizen.getCountry());
    }
}
