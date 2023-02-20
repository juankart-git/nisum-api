package com.nisum.api.mapper;

import com.nisum.api.persistence.entity.User;
import com.nisum.api.service.dto.UserInDTO;
import com.nisum.api.service.dto.UserOutDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserDTOtoUser implements IMapper<UserInDTO, User>{

    @Override
    public User map(UserInDTO in){
        User user = new User();
        user.setName(in.getName());
        user.setMail(in.getMail());
        user.setPassword(in.getPassword());
        user.setActive(true);
        user.setCreated(new Date());
        user.setLastLogin(new Date());
        user.setPhones(in.getPhones());
        user.setToken(UUID. randomUUID());
        return user;
    }

    public UserOutDTO map(User in){
        UserOutDTO user = new UserOutDTO();
        user.setActive(true);
        user.setCreated(new Date());
        user.setLastLogin(new Date());
        user.setToken(UUID. randomUUID());
        user.setId(in.getId());
        return user;
    }

}
