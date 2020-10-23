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


    /***
     * Simple get request that
     * @return all existing cars
     */
    @GetMapping("/getAllCars")
    public @ResponseBody Iterable<Cars> getAllCpu() {
        Iterable<Cars> values =  carsService.getAllCars();
        return values;
    }

    /**
     * add new record to database
     * @param carModel - new record
     * @return message
     */
    @PostMapping("/addCar")
    public String  addCar(@ModelAttribute CarModel carModel){
        carsService.addNewCar(carModel);
        return "New car was successfully added";
    }

    /***
     * find record by id and set new values
     * @param id - id of existing record, that should be modified
     * @param carModel - new values for record
     * @return message
     */
    @PutMapping("/update/{id}")
    public String updateCar(@PathVariable("id") int id, @ModelAttribute CarModel carModel){
        carsService.updateById(id, carModel);
        return "car was successfully updated";
    }


    /***
     * find record by id and delete it
     * @param id - if of record that should be deleted
     * @return message
     */
    @DeleteMapping("/delete/{id}")
    public String removeCar(@PathVariable("id") int id){
        carsService.removeById(id);
        return "car was successfully removed";
    }



}