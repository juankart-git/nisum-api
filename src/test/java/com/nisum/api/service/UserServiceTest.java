package com.nisum.api.service;

import com.nisum.api.persistence.entity.Phone;
import com.nisum.api.persistence.entity.User;
import com.nisum.api.persistence.repository.UserRepository;
import com.nisum.api.service.dto.UserInDTO;
import com.nisum.api.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Autowired
    private Validator validator;

    @InjectMocks
    private UserService service;

    private User user;

    private Phone phone;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        List<Phone> phones = new ArrayList<>();
        phone = new Phone();
        phone.setCityCode("1");
        phone.setCountryCode("2");
        phone.setNumber("12346");
        phones.add(phone);

        user = new User();
        user.setName("Pepito");
        user.setPassword("123456Aa.");
        user.setMail("pepito@correo.com");
        user.setPhones(phones);
    }


    @Test
    void getAllUsers() {
        when(repository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(service.getAllUsers());
    }
}