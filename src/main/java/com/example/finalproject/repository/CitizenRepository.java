package com.example.finalproject.repository;

import com.example.finalproject.entity.Citizen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitizenRepository extends CrudRepository<Citizen,Long> {
    List<Citizen> findAllByCountryId(long countryId);
}
