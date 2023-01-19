package com.example.SpringSecurity.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter

public class JwtAuthenticationException extends  ArithmeticException{
    private HttpStatus httpStatus;
    public JwtAuthenticationException(String s, Throwable t) {

        super(s);
    }

    public JwtAuthenticationException(String s, HttpStatus unauthorized) {
        super(s);
    }
}
