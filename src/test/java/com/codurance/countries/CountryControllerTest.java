package com.codurance.countries;

import com.codurance.countries.controller.CountryController;
import com.codurance.countries.domain.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CountryControllerTest {

    @Autowired
    CountryController countryController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    @Rollback
    public void create_country(){
        Country country = countryController.create_country("Croatia");

        Assert.assertNotNull(country.getId());

    }
}
