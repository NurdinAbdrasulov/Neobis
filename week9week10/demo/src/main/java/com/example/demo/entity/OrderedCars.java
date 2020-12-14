package com.example.demo.entity;

import com.example.demo.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *Сушьность содержит инфо о машинах, которые были заказанны у производителей.
 * Такое может произойти в след случаях:
 * магазин заказывает машины для себя
 * магазин заказывает машины для клента
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "ordered_cars")
public class OrderedCars {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<Cars> cars;

    private int countOfCars;
    private Date OrderDate;//дата, когда было заказанно

    @Enumerated(EnumType.STRING)
    private Status status;
}
