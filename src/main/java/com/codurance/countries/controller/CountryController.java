package com.codurance.countries.controller;

import com.codurance.countries.domain.Country;
import com.codurance.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping(
            path= "/country",
            produces = { MediaType.APPLICATION_JSON_VALUE},
            consumes = MediaType.ALL_VALUE)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Country create_country(@RequestBody String name) {

        //Param name validation

        //Domain object creation
        Country country = new Country(name);

        //Returning the created object
        return countryService.create_country(country);
    }
}
