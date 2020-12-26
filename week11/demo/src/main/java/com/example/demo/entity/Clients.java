package com.example.demo.entity;

import com.example.demo.entity.enums.Gender;
import com.example.demo.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "clients")
public class Clients {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private Date dateOfBirth;
    private String phoneNumber;
    private Date registrationDate;

    private String password;
    private String login;

    @Enumerated(EnumType.STRING)
    private Role role;
}
