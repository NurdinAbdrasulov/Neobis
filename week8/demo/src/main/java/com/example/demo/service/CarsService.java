package com.example.demo.service;

import com.example.demo.entity.Cars;
import com.example.demo.model.CarModel;
import com.example.demo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarsService {
    @Autowired
    private CarsRepository carsRepository;


    public Iterable<Cars> getAllCars() {
        Iterable<Cars> cars = carsRepository.findAll();
        return cars;
    }

    public Optional<Cars> getCarById(int id) {
        return carsRepository.findById(id);
    }

    public void addNewCar(CarModel carModel) {
        Cars car = new Cars();
//        car.setBrand(carModel.getBrand());
        car.setBodyStyle(carModel.getBodyStyle());
        car.setModel(carModel.getModel());
        car.setYearOfManufacture(carModel.getYearOfManufacture());
        car.setColor(carModel.getColor());
        car.setPrice(carModel.getPrice());

        carsRepository.save(car);
    }

    public void removeById(int id) {
        carsRepository.deleteById(id);
    }

    public void updateById(int id, CarModel carModel) {
        Optional<Cars> car = carsRepository.findById(id);
        if (car.isPresent()) {
            Cars updatedCar = car.get();

            updatedCar.setModel(carModel.getModel());
            updatedCar.setPrice(carModel.getPrice());
            updatedCar.setColor(carModel.getColor());
            updatedCar.setBodyStyle(carModel.getBodyStyle());
            updatedCar.setBrand(carModel.getBrand());
            updatedCar.setYearOfManufacture(carModel.getYearOfManufacture());

            carsRepository.save(updatedCar);
        }

    }
}
