package com.wendy.demo.user.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long id;

    private String name;

    private String surnames;

    private String email;

    private String documentType;
    private String documentNumber;
    private LocalDate birthday;
    private boolean active;
}
