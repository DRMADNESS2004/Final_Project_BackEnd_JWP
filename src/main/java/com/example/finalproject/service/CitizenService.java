package com.example.finalproject.service;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.entity.Country;
import com.example.finalproject.exception.ResourceNotFoundException;
import com.example.finalproject.repository.CitizenRepository;
import com.example.finalproject.request.CitizenRequest;
import com.example.finalproject.request.CountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public List<Citizen> getAllCitizens(){
        return citizenRepository.findAll();
    }

    public void deleteCitizen(long citizenId){
        if(citizenRepository.existsById(citizenId)){
            citizenRepository.deleteById(citizenId);
        }
        else{
            throw new ResourceNotFoundException("citizen id was not found");
        }
    }

    public Citizen updateCitizen(long citizenId, CitizenRequest citizenRequest){
        Citizen citizen=citizenRepository.findById(citizenId).orElseThrow(()->new ResourceNotFoundException("citizen id was not found"));
        Citizen citizenToBeUpdated=new Citizen(citizenRequest);
        citizenToBeUpdated.setId(citizenId);
        citizenToBeUpdated.setCountry(citizen.getCountry());
        return citizenRepository.save(citizenToBeUpdated);
    }
}
