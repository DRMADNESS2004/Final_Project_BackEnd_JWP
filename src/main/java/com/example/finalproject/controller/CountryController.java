package com.example.finalproject.controller;

import com.example.finalproject.entity.Country;
import com.example.finalproject.repository.CountryRepository;
import com.example.finalproject.request.CountryRequest;
import com.example.finalproject.response.CountryResponse;
import com.example.finalproject.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}")
    public List<CountryResponse> getAllCountries(){
        List<Country> countries=countryService.getAllCountries();
        List<CountryResponse> countryResponses=new ArrayList<>();

        countries.forEach(country->{
            CountryResponse countryResponse=new CountryResponse(country);
            countryResponses.add(countryResponse);
        });

        return countryResponses;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryResponse addCountry(@Valid @RequestBody CountryRequest countryRequest){
        Country savedCountry=countryService.addCountry(countryRequest);
        return new CountryResponse(savedCountry);
    }
}
