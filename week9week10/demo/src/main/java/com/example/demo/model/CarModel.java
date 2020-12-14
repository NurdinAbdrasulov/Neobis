package com.example.demo.model;

import com.example.demo.entity.CarBrands;
import com.example.demo.entity.CarModels;
import com.example.demo.entity.Manufacturers;
import com.example.demo.entity.enums.BodyStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {
    private int id;
    private CarBrands brand;
    private CarModels model;
    private BodyStyle bodyStyle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfManufacture;

    private String color;
    private Manufacturers manufacturer;
    private double price;



}
