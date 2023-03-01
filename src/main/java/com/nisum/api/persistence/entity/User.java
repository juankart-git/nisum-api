package com.nisum.api.persistence.entity;

import com.nisum.api.util.Constants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity (name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = Constants.EMPTY_NAME)
    private String name;

    @Column(unique = true )
    @NotNull(message = Constants.EMPTY_EMAIL)
    @Email(message = Constants.INVALID_EMAIL)
    private String mail;

    @NotNull(message = Constants.INVALID_PASSWORD)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,]).{8,20}$",
            message = Constants.INVALID_PASSWORD)
    private String password;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private UUID token;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "user_id")
    private List<Phone> phones;
}
