package com.nisum.api.service.dto;

import com.nisum.api.persistence.entity.Phone;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserInDTO {

    private UUID id;

    private String name;

    private String mail;

    private String password;

    private List<Phone> phones;
}
