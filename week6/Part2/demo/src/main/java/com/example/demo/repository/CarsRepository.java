package com.example.demo.repository;

import com.example.demo.entity.Cars;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends CrudRepository<Cars, Integer> {

}