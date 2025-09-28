package com.quoteExpress.quoteExpress.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncodePassword {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EncodePassword(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public String enccodePwd(String pwd){
        return passwordEncoder.encode(pwd);
    }
}
