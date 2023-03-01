package com.nisum.api.service;

import com.nisum.api.exception.NisumExceptions;
import com.nisum.api.mapper.UserDTOtoUser;
import com.nisum.api.persistence.entity.User;
import com.nisum.api.persistence.repository.UserRepository;
import com.nisum.api.service.dto.UserInDTO;
import com.nisum.api.service.dto.UserOutDTO;
import com.nisum.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOtoUser mapper;

    public UserService(UserRepository userRepository, UserDTOtoUser mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserOutDTO createUser(UserInDTO userDTO){
        List<User> existUser = Optional.ofNullable(this.userRepository.findByMail(userDTO.getMail())).get();
        if(existUser.size() > 0)
            throw new NisumExceptions(Constants.REGISTERED_EMAIL, HttpStatus.NOT_ACCEPTABLE);
        return mapper.map(this.userRepository.save(mapper.map(userDTO)));
    }

    public User updateUser(UserInDTO userDTO){
        return this.userRepository.save(mapper.map(userDTO));
    }

    public void deleteUser(UserInDTO userDTO){
        this.userRepository.delete(mapper.map(userDTO));
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

}
