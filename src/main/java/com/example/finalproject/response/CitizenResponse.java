package com.example.finalproject.response;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.entity.Job;
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
    private boolean isSelected;
    private CountryResponse country;
    private JobResponse job;

    public CitizenResponse(Citizen citizen){
        id=citizen.getId();
        name=citizen.getName();
        isSelected= citizen.isSelected();
        country=new CountryResponse(citizen.getCountry());
        job=new JobResponse(citizen.getJob());
    }
}
