package com.example.demo.entity;

import com.example.demo.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущьность содержить инфо о всех продажах:
 * удачных,
 * отмененных,
 * провальных,
 * в процессе - к примеру клиент заказал авто и/или будет оплачавет покупку в течение нескольких месяцев.
 * Одна запись - продажа одного или нескольких машин одного типа
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "sales")
public class Sales {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Clients clients;

    @ManyToOne
    private Employees employee;

    @ManyToOne////
    private Cars car;

    private int countOfCars;
    private Date registrationDate;
    private double paymentAmount;// итоговая сумма к оплате
    private double paid;// сколько уже оплачено

    @Enumerated(EnumType.STRING)
    private Status status;
}
