package com.example.demo.service;

import com.example.demo.entity.CarBrands;
import com.example.demo.repository.CarBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBrandsService {

    @Autowired
    private CarBrandsRepository carBrandsRepository;

    public Iterable<CarBrands> getAllCarBrands(){
        return carBrandsRepository.findAll();
    }
}
