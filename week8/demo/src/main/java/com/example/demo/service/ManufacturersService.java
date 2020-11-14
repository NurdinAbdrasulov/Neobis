package com.example.demo.service;

import com.example.demo.entity.CarBrands;
import com.example.demo.entity.Manufacturers;
import com.example.demo.model.ManufacturerModel;
import com.example.demo.repository.ManufacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturersService {
    
    @Autowired
    private ManufacturesRepository manufacturesRepository;

    @Autowired
    private CarBrandsService carBrandsService;
    
    public Iterable<Manufacturers> getAllManufactures(){
       return manufacturesRepository.findAll();
    }

    public List<CarBrands> getCarBrands() {
        Iterable<CarBrands> allCarBrands = carBrandsService.getAllCarBrands();
        List<CarBrands> list = new ArrayList<>();
        for(CarBrands carBrand: allCarBrands)
            list.add(carBrand);

        return list;
    }

    public void addManufacturer(ManufacturerModel manufacturerModel) {
        Manufacturers manufacturer = new Manufacturers();
        manufacturer.setBrand(manufacturerModel.getBrand());
        manufacturer.setCountry(manufacturerModel.getCountry());
        manufacturer.setAddress(manufacturerModel.getPhoneNumber());
        manufacturer.setPhoneNumber(manufacturerModel.getPhoneNumber());

        manufacturesRepository.save(manufacturer);
    }
}
