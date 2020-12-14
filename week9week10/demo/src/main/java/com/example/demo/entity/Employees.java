package com.example.demo.entity;

import com.example.demo.entity.enums.Gender;
import com.example.demo.entity.enums.Position;
import com.example.demo.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private String phoneNumber;
    private String login;
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;

}
