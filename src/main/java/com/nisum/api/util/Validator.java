package com.nisum.api.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

   public boolean emailValidator(String email){
       String regx = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
       Pattern pattern = Pattern.compile(regx);
       Matcher matcher = pattern.matcher(email);
       return matcher.matches();
   }

    public boolean passwordValidator(String password){
        String regx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
