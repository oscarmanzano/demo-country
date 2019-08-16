package com.codurance.countries;

import com.codurance.countries.controller.UserController;
import com.codurance.countries.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AbmCountriesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    @Rollback
    public void create_country() throws Exception {

        mockMvc.perform(post("/country")
                .content("pq"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    public void validate_user() throws Exception {
        mockMvc.perform(get("/users?username=oscar&password=manzano"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    public void validate_user_without_params() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isBadRequest());
    }

    @Transactional
    @Rollback
    @Test
    public void create_user() throws Exception {
        mockMvc.perform(post("/users")
                .param("username", "sharon")
                .param("password", "stone"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber());
    }

}
