package com.example.finalproject.controller;

import com.example.finalproject.entity.PossibleCountry;
import com.example.finalproject.response.PossibleCountryResponse;
import com.example.finalproject.service.PossibleCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/possibleCountries")
public class PossibleCountryController {
    @Autowired
    PossibleCountryService possibleCountryService;

    @GetMapping
    public List<PossibleCountryResponse> getAllPossibleCountries(){
        List<PossibleCountry> possibleCountries=possibleCountryService.getAllPossibleCountries();
        List<PossibleCountryResponse> possibleCountryResponses=new ArrayList<>();

        possibleCountries.forEach((possibleCountry)->{
            PossibleCountryResponse possibleCountryResponse=new PossibleCountryResponse(possibleCountry);
            possibleCountryResponses.add(possibleCountryResponse);
        });

        return possibleCountryResponses;
    }
}
