package com.codurance.countries.service;

import com.codurance.countries.domain.Country;
import com.codurance.countries.infrastructure.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public Country create_country(Country country) {

        return countryRepository.save(country);
    }
}
