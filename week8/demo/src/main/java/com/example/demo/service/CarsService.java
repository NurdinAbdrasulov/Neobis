package com.example.demo.service;

import com.example.demo.entity.CarBrands;
import com.example.demo.entity.CarModels;
import com.example.demo.entity.Cars;
import com.example.demo.entity.Manufacturers;
import com.example.demo.model.CarModel;
import com.example.demo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private ManufacturersService manufacturersService;

    @Autowired
    private CarBrandsService carBrandsService;

    @Autowired
    private CarModelsService carModelsService;

    public Iterable<Cars> getAllCars(){
        Iterable<Cars> cars = carsRepository.findAll();
        return cars;
    }

    public void addNewCar(CarModel carModel){
        Cars car = new Cars();
        car.setBrand(carModel.getBrand());
        car.setBodyStyle(carModel.getBodyStyle());
        car.setModel(carModel.getModel());
        car.setYearOfManufacture(carModel.getYearOfManufacture());
        car.setColor(carModel.getColor());
        car.setPrice(carModel.getPrice());

        carsRepository.save(car);
//        System.out.println("car was saved");
    }

    public void removeById(int id){
        carsRepository.deleteById(id);
//        System.out.println("car was deleted");

    }

    public void updateById(int id, CarModel carModel) {
        Optional<Cars> car = carsRepository.findById(id);
        if(car.isPresent()) {
            Cars updatedCar = car.get();

            updatedCar.setModel(carModel.getModel());
            updatedCar.setPrice(carModel.getPrice());
            updatedCar.setColor(carModel.getColor());
            updatedCar.setBodyStyle(carModel.getBodyStyle());
            updatedCar.setBrand(carModel.getBrand());
            updatedCar.setYearOfManufacture(carModel.getYearOfManufacture());

            carsRepository.save(updatedCar);
//            System.out.println("car was updated");
        }

    }

    public List<Manufacturers> getManufactures() {
        Iterable<Manufacturers> allManufactures = manufacturersService.getAllManufactures();
        List<Manufacturers> list = new ArrayList<>();

        for(Manufacturers val: allManufactures)
            list.add(val);
        return  list;

    }

    public List<CarBrands> getCarBrands() {
        Iterable<CarBrands> carBrands = carBrandsService.getAllCarBrands();
        List<CarBrands> list = new ArrayList<>();

        for(CarBrands brand: carBrands)
            list.add(brand);
        return list;

    }

    public List<CarModels> getCarModels() {
        Iterable<CarModels> carModels = carModelsService.getAllCarModels();
        List<CarModels> list = new ArrayList<>();

        for(CarModels val: carModels)
            list.add(val);
        return list;
    }
}
