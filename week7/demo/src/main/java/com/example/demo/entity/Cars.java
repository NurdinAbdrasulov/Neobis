package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "body_style")
    private String bodyStyle;

    @Column(name = "year_of_manufacture")
    private Date yearOfManufacture;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

}

