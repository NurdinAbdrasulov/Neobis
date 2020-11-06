package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
public class CarModel {
    private int id;
    private String brand;
    private String model;
    private String bodyStyle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearOfManufacture;

    private String color;
    private double price;

    public CarModel(int id, String brand, String model, String bodyStyle, Date yearOfManufacture, String color, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
    }

}
