package com.example.demo.controller;

import com.example.demo.entity.Cars;
import com.example.demo.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarsService;


@Controller
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;


    @GetMapping("/getAllCars")
    public @ResponseBody Iterable<Cars> getAllCpu() {
        Iterable<Cars> values =  carsService.getAllCars();
        return values;
    }

    @PostMapping("/addCar")
    public String  addCar(@ModelAttribute CarModel carModel){
        carsService.addNewCar(carModel);
        return "New car was successfully added";
    }

    @PutMapping("/update/{id}")
    public String updateCar(@PathVariable("id") int id, @ModelAttribute CarModel carModel){
        carsService.updateById(id, carModel);
        return "car was successfully updated";
    }


    @DeleteMapping("/delete/{id}")
    public String removeCar(@PathVariable("id") int id){
        carsService.removeById(id);
        return "car was successfully removed";
    }



}