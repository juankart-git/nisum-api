package com.nisum.api.persistence.entity;

import com.nisum.api.util.Constants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = Constants.EMPTY_PHONE)
    private String number;

    @NotNull(message = Constants.EMPTY_CITY_CODE)
    private String cityCode;

    @NotNull(message = Constants.EMPTY_COUNTRY_CODE)
    private String countryCode;

}
