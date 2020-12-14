package com.example.demo.service;

import com.example.demo.entity.CarModels;
import com.example.demo.model.CarModel;
import com.example.demo.repository.CarModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarModelsService {

    @Autowired
    private CarModelsRepository carModelsRepository;


    public Iterable<CarModels> getAllCarModels(){
        return carModelsRepository.findAll();
    }
}
