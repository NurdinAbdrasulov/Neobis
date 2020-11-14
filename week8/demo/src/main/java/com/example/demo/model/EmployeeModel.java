package com.example.demo.model;

import com.example.demo.enums.Gender;
import com.example.demo.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private int id;
    private String fio;
    private Position position;
    private Gender gender;
    private String address;
    private String phoneNumber;
    private String login;
    private String password;

}
