package com.ai.be.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class PasswordUtil {

    public boolean isValidPassword(String inputPassword, String encryptedPassword){
        return BCrypt.checkpw(inputPassword, encryptedPassword);
    }
    public String getPassword() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 6);
    }

    public String encodePassword(String password) {
        return  BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
