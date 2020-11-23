package com.example.demo.controller;

import com.example.demo.model.CarBrandModel;
import com.example.demo.service.CarBrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carBrand")
public class CarBrandsController {

    @Autowired
    private CarBrandsService carBrandsService;

    @GetMapping("getAll")
    public List getAllBrands(){
        return carBrandsService.getAllCarBrands();
    }

    @GetMapping("get/{id}")
    public CarBrandModel getCarBrand(@PathVariable int id){
        return carBrandsService.getCarBrandById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id){
        return carBrandsService.deleteById(id);
    }

    @PostMapping("add")
    public String addNewBrand(@ModelAttribute CarBrandModel model){
        return carBrandsService.addNewBrand(model);
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable int id, @ModelAttribute CarBrandModel model){
        return carBrandsService.updateById(id,model);
    }
}
