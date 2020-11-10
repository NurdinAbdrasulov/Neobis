package com.example.demo.entity;

import com.example.demo.enums.BodyStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/***
 * Сущьность представляет все возможные машины, которые можно купить/заказать в магазине
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "cars")
public class Cars {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @JoinColumn(name = "brand")
    @ManyToOne
    private CarBrands brand;

//    @JoinColumn(name = "model")
    @ManyToOne
    private CarModels model;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_style")
    private BodyStyle bodyStyle;

    @Column(name = "year_of_manufacture")
    private Date yearOfManufacture;

    @Column(name = "color")
    private String color;

    @ManyToOne////
    private Manufacturers manufacturer;

    @Column(name = "price")
    private double price;

}

