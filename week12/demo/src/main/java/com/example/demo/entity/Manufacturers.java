package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/***
 * Сущьность представляет производителя - заводы, фабрики, где производять машины.
 * Производители, откуда привозят машины для продажи в данный магазин.
 * К примеру машины марки Mercedes-Benz могут выпускаться в Японии, Германии, США и т.д.
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "manufacturers")
public class Manufacturers {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private CarBrands brand;//название завода

    private String country;
    private String address;
    private String phoneNumber;
}
