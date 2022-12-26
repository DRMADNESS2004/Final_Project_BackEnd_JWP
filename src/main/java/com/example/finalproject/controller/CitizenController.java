package com.example.finalproject.controller;

import com.example.finalproject.entity.Citizen;
import com.example.finalproject.request.CitizenRequest;
import com.example.finalproject.request.CountryRequest;
import com.example.finalproject.response.CitizenResponse;
import com.example.finalproject.service.CitizenService;
import com.example.finalproject.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/citizens")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @GetMapping()
    public List<CitizenResponse> getAllCitizens(){
        List<Citizen> citizens=citizenService.getAllCitizens();
        List<CitizenResponse> citizenResponses=new ArrayList<>();
        citizens.forEach((citizen)->{
            citizenResponses.add(new CitizenResponse(citizen));
        });
        return citizenResponses;
    }

    @DeleteMapping("/{citizenId}")
    public void deleteCitizen(@PathVariable long citizenId){
        citizenService.deleteCitizen(citizenId);
    }

    @PutMapping("/{citizenId}")
    public CitizenResponse updateCitizen(@PathVariable long citizenId, @Valid @RequestBody CitizenRequest citizenRequest){
        return new CitizenResponse(citizenService.updateCitizen(citizenId,citizenRequest));
    }
}
