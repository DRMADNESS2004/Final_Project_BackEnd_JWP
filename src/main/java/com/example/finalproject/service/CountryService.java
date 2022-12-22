package com.example.finalproject.service;

import com.example.finalproject.entity.Country;
import com.example.finalproject.repository.CountryRepository;
import com.example.finalproject.request.CountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country addCountry(CountryRequest countryRequest){
        Country country=new Country(countryRequest);
        return countryRepository.save(country);
    }
}
