package com.example.demo.repository;

import com.example.demo.entity.CarBrands;
import org.springframework.data.repository.CrudRepository;

public interface CarBrandsRepository extends CrudRepository<CarBrands, Integer> {
}
