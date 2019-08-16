package com.codurance.countries;

import com.codurance.countries.domain.Country;
import com.codurance.countries.service.CountryService;
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
public class CountryServiceTest {

    @Autowired
    CountryService countryService;


    @Test
    @Transactional
    @Rollback
    public void create_country() {
        Country country = new Country("Spain");

        Country countryResult = countryService.create_country(country);

        Assert.assertNotNull(countryResult.getId());
    }
}
