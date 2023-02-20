package com.nisum.api.service.dto;

import com.nisum.api.persistence.entity.Phone;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class UserOutDTO {

    private UUID id;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private UUID token;

    private boolean active;
}
