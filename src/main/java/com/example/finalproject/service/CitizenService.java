package com.example.finalproject.service;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.exception.ResourceNotFoundException;
import com.example.finalproject.repository.CitizenRepository;
import com.example.finalproject.request.CitizenRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public void deleteCitizen(long citizenId){
        if(citizenRepository.existsById(citizenId)){
            citizenRepository.deleteById(citizenId);
        }
        else{
            throw new ResourceNotFoundException("citizen id was not found");
        }
    }

    public Citizen updateCitizen(long citizenId, CitizenRequest citizenRequest){
        if(citizenRepository.existsById(citizenId)){
            Citizen citizenToBeUpdated=new Citizen(citizenRequest);
            citizenToBeUpdated.setId(citizenId);
            return citizenRepository.save(citizenToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("citizen id was not found");
        }
    }
}
