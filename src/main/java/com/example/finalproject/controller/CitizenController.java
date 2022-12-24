package com.example.finalproject.controller;

import com.example.finalproject.request.CitizenRequest;
import com.example.finalproject.request.CountryRequest;
import com.example.finalproject.response.CitizenResponse;
import com.example.finalproject.service.CitizenService;
import com.example.finalproject.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/citizens")
public class CitizenController {
    @Autowired
    private CitizenService citizenService;

    @GetMapping("/{citizenId}")
    public CitizenResponse getCitizen(@PathVariable long citizenId){
        return new CitizenResponse((citizenService.getCitizen(citizenId)));
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
