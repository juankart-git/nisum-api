package com.nisum.api.service;

import com.nisum.api.exception.NisumExceptions;
import com.nisum.api.mapper.UserDTOtoUser;
import com.nisum.api.persistence.entity.User;
import com.nisum.api.persistence.repository.UserRepository;
import com.nisum.api.service.dto.UserInDTO;
import com.nisum.api.service.dto.UserOutDTO;
import com.nisum.api.util.Constants;
import com.nisum.api.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOtoUser mapper;
    private final Constants constants;

    @Autowired
    private Validator validator;

    public UserService(UserRepository userRepository, UserDTOtoUser mapper, Constants constants) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.constants = constants;
    }

    public UserOutDTO createUser(UserInDTO userDTO){

        if(!validator.emailValidator(userDTO.getMail())){
            throw new NisumExceptions(constants.INVALID_EMAIL, HttpStatus.BAD_REQUEST);
        }
        if(!validator.passwordValidator(userDTO.getPassword())){
            throw new NisumExceptions(constants.INVALID_PASSWORD, HttpStatus.BAD_REQUEST);
        }
        try {
            return mapper.map(this.userRepository.save(mapper.map(userDTO)));
        } catch (DataIntegrityViolationException ex){
            throw new NisumExceptions(constants.REGISTERED_EMAIL, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception ex){
            throw new NisumExceptions(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
