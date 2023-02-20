package com.nisum.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.api.persistence.entity.Phone;
import com.nisum.api.persistence.entity.User;
import com.nisum.api.service.dto.UserInDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
class UserControllerTest {

    private final static String BASE_URL = "/users";

    MockMvc mockMvc;

    private UserInDTO user;

    private Phone phone;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        List<Phone> phones = new ArrayList<>();
        phone = new Phone();
        phone.setCityCode("1");
        phone.setCountryCode("2");
        phone.setNumber("12346");
        phones.add(phone);

        user = new UserInDTO();
        user.setName("Pepito");
        user.setPassword("123456Aa.");
        user.setMail("pepito@correo.com");
        user.setPhones(phones);


    }

    @Test
    void createUser() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapToJson(user)))
                .andReturn();
        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }


    @Test
    void getAllUsers() throws Exception {
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andReturn();
        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}