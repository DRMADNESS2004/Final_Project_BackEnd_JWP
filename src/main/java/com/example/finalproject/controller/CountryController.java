package com.example.finalproject.controller;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.entity.Country;
import com.example.finalproject.repository.CountryRepository;
import com.example.finalproject.request.CitizenRequest;
import com.example.finalproject.request.CountryRequest;
import com.example.finalproject.response.CitizenResponse;
import com.example.finalproject.response.CountryResponse;
import com.example.finalproject.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping()
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

    @DeleteMapping("/{countryId}")
    public void deleteCountry(@PathVariable long countryId){
        countryService.deleteCountry(countryId);
    }

    @PutMapping("/{countryId}")
    public CountryResponse updateCountry(@PathVariable long countryId, @Valid @RequestBody CountryRequest countryRequest){
        return new CountryResponse(countryService.updateCountry(countryId,countryRequest));
    }

    @PostMapping("/{countryId}/citizens")
    @ResponseStatus(HttpStatus.CREATED)
    public CitizenResponse addCitizen(@PathVariable long countryId, @RequestBody @Valid CitizenRequest citizenRequest){
        return new CitizenResponse(countryService.addCitizen(countryId,citizenRequest));
    }

    @GetMapping("/{countryId}/citizens")
    public List<CitizenResponse> getAllCitizens(@PathVariable long countryId){
        List<Citizen> citizens=countryService.getAllCitizens(countryId);
        List<CitizenResponse> citizenResponses=new ArrayList<>();
        for(int i=0;i<citizens.size();i++){
            citizenResponses.add(new CitizenResponse(citizens.get(i)));
        }
        return citizenResponses;
    }
}
