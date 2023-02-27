package com.wendy.demo.user.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")

@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surnames;

    private String email;

    private String documentType;
    private String documentNumber;
    private LocalDate birthday;
    private boolean active;
}
