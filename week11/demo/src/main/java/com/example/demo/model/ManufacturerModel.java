package com.example.demo.model;

import com.example.demo.entity.CarBrands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerModel {
    private int id;
    private CarBrands brand;
    private String country;
    private String address;
    private String phoneNumber;
}
