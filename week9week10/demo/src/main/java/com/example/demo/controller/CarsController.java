package com.example.demo.controller;

import com.example.demo.entity.Cars;
import com.example.demo.model.CarModel;
import com.example.demo.service.CarsService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/cars")
@PreAuthorize("hasAuthority('car')")
public class CarsController {

    @Autowired
    private CarsService carsService;

    /***
     * Simple get request that
     * @return all existing cars
     */
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('чтение')")
    public Iterable<Cars> getAllCars() {
        Iterable<Cars> values =  carsService.getAllCars();
        return values;
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('чтение')")
    public Optional<Cars> getCar(@PathVariable int id){
        Optional<Cars> car = carsService.getCarById(id);
        return car;
    }

    /**
     * add new record to database
     * @param carModel - new record
     * @return message
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('добавление')")
    public String  addCar(@RequestBody CarModel carModel){
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
    @PreAuthorize("hasAuthority('обновление')")
    public String updateCar(@PathVariable("id") int id, @RequestBody CarModel carModel){
        carsService.updateById(id, carModel);
        return "result: car was successfully updated";
    }


    /***
     * find record by id and delete it
     * @param id - id of record that should be deleted
     * @return message
     */
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('удаление')")
    public String removeCar(@PathVariable("id") int id){
        carsService.removeById(id);
        return "result: car was successfully removed";
    }





}