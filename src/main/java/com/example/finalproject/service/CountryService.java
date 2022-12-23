package com.example.finalproject.service;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.entity.Country;
import com.example.finalproject.exception.ResourceNotFoundException;
import com.example.finalproject.repository.CitizenRepository;
import com.example.finalproject.repository.CountryRepository;
import com.example.finalproject.request.CitizenRequest;
import com.example.finalproject.request.CountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CitizenRepository citizenRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country addCountry(CountryRequest countryRequest){
        Country country=new Country(countryRequest);
        return countryRepository.save(country);
    }

    public Citizen addCitizen(long countryId, CitizenRequest citizenRequest){
        Country country=countryRepository.findById(countryId).orElseThrow(
                ()->new ResourceNotFoundException("country id was not found"));

        Citizen citizenToBeSaved=new Citizen(citizenRequest);
        citizenToBeSaved.setCountry(country);
        return citizenRepository.save(citizenToBeSaved);
    }

    public List<Citizen> getAllCitizens(long countryId){
        return citizenRepository.findAllByCountryId(countryId);
    }
}
