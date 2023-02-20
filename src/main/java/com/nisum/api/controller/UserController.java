package com.nisum.api.controller;

import com.nisum.api.persistence.entity.User;
import com.nisum.api.service.UserService;
import com.nisum.api.service.dto.UserInDTO;
import com.nisum.api.service.dto.UserOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/V1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<UserOutDTO> createUser(@RequestBody UserInDTO user){
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @GetMapping(produces = { "application/json" })
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
