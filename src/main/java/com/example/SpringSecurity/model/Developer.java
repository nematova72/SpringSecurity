package com.example.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Data
@AllArgsConstructor
public class Developer {

    private int id;
    private String firstName;
    private String lastName;

}
