package com.example.finalproject.service;

import com.example.finalproject.entity.PossibleCountry;
import com.example.finalproject.repository.PossibleCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PossibleCountryService {
    @Autowired
    PossibleCountryRepository possibleCountryRepository;

    public List<PossibleCountry> getAllPossibleCountries(){return possibleCountryRepository.findAll();}
}
