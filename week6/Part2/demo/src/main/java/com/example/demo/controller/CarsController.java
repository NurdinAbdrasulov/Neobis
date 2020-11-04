package com.example.demo.controller;

import com.example.demo.entity.Cars;
import com.example.demo.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarsService;


@RestController
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;


    /***
     * Simple get request that
     * @return all existing cars
     */
    @GetMapping("/getAllCars")
//    @ResponseBody
    public Iterable<Cars> getAllCpu() {
        Iterable<Cars> values =  carsService.getAllCars();
        return values;
    }

    /**
     * add new record to database
     * @param carModel - new record
     * @return message
     */
    @PostMapping("/addCar")
//    @ResponseBody
    public String  addCar(@ModelAttribute CarModel carModel){
        carsService.addNewCar(carModel);
        return "result: New car was successfully added";
    }

    /***
     * find record by id and set new values
     * @param id - id of existing record, that should be modified
     * @param carModel - new values for record
     * @return message
     */
    @PutMapping("/update/{id}")
//    @ResponseBody
    public String updateCar(@PathVariable("id") int id, @ModelAttribute CarModel carModel){
        carsService.updateById(id, carModel);
        return "result: car was successfully updated";
    }


    /***
     * find record by id and delete it
     * @param id - id of record that should be deleted
     * @return message
     */
    @DeleteMapping("/delete/{id}")
//    @ResponseBody
    public String removeCar(@PathVariable("id") int id){
        carsService.removeById(id);
        return "result: car was successfully removed";
    }



}