package com.example.demo.service;

import com.example.demo.entity.CarBrands;
import com.example.demo.entity.Manufacturers;
import com.example.demo.model.ManufacturerModel;
import com.example.demo.repository.ManufacturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturersService {
    
    @Autowired
    private ManufacturesRepository manufacturesRepository;
    
    public Iterable<Manufacturers> getAllManufactures(){
       return manufacturesRepository.findAll();
    }


    public void addManufacturer(ManufacturerModel manufacturerModel) {
        Manufacturers manufacturer = new Manufacturers();
        manufacturer.setBrand(manufacturerModel.getBrand());
        manufacturer.setCountry(manufacturerModel.getCountry());
        manufacturer.setAddress(manufacturerModel.getPhoneNumber());
        manufacturer.setPhoneNumber(manufacturerModel.getPhoneNumber());

        manufacturesRepository.save(manufacturer);
    }

    public Optional<Manufacturers> getManufactureById(int id) {
        return manufacturesRepository.findById(id);
    }

    public void update(int id, ManufacturerModel manufacturerModel) {
        Optional<Manufacturers> optinal = manufacturesRepository.findById(id);
        if(optinal.isPresent()){
            Manufacturers manufacturer = optinal.get();
            manufacturer.setBrand(manufacturerModel.getBrand());
            manufacturer.setCountry(manufacturerModel.getCountry());
            manufacturer.setAddress(manufacturerModel.getPhoneNumber());
            manufacturesRepository.save(manufacturer);
        }//throw exception if not found
    }

    public void delete(int id) {
        manufacturesRepository.deleteById(id);
    }
}
