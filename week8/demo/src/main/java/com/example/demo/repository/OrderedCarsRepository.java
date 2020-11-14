package com.example.demo.repository;

import com.example.demo.entity.OrderedCars;
import org.springframework.data.repository.CrudRepository;

public interface OrderedCarsRepository extends CrudRepository<OrderedCars, Integer> {
}
