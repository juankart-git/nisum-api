package com.nisum.api.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static final String INVALID_EMAIL = "Invalid email";

    public static final String INVALID_PASSWORD = "Invalid password, doesn't comply with the minimum defined policies";

    public static final String REGISTERED_EMAIL = "Email is already registered";

    public static final String EMPTY_EMAIL = "Email shouldn't be null";

    public static final String EMPTY_NAME = "Name shouldn't be null";

    public static final String EMPTY_PASSWORD = "Password shouldn't be null";

    public static final String EMPTY_PHONE = "Phone number shouldn't be null";

    public static final String EMPTY_CITY_CODE = "City code shouldn't be null";

    public static final String EMPTY_COUNTRY_CODE = "Country code shouldn't be null";

}
