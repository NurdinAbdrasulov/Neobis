package com.example.demo.service;

import com.example.demo.daoRepository.CarBrandRepository;
import com.example.demo.model.CarBrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandsService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<CarBrandModel> getAllCarBrands(){
        return carBrandRepository.getAllCarBrands();
    }

    public CarBrandModel getCarBrandById(int id) {

        return carBrandRepository.getBrandById(id);
    }

    public String deleteById(int id) {
        int result = carBrandRepository.deleteById(id);
        return result > 0 ? "{\"result\":\"car brand was successfully deleted\"}" : "{\"result\":\"failed\"}";
    }

    public String addNewBrand(CarBrandModel model) {
        int result = carBrandRepository.addNewBrand(model);
        return result > 0 ? "{\"result\":\"car brand was successfully added\"}" : "{\"result\":\"failed\"}";
    }

    public String updateById(int id, CarBrandModel model) {
        int result = carBrandRepository.update(id, model);
        return result > 0 ? "{\"result\":\"car brand was successfully updated\"}" : "{\"result\":\"failed\"}";
    }
}
