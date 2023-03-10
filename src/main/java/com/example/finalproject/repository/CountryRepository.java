package com.example.finalproject.repository;

import com.example.finalproject.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
    List<Country> findAll();
}
