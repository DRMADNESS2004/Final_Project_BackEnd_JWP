package com.example.finalproject.repository;

import com.example.finalproject.entity.PossibleCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossibleCountryRepository extends CrudRepository<PossibleCountry,Long> {
    List<PossibleCountry> findAll();
}
