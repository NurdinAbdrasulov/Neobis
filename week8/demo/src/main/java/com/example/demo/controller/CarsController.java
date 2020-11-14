package com.example.demo.controller;

import com.example.demo.entity.Cars;
import com.example.demo.enums.BodyStyle;
import com.example.demo.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarsService;


@Controller
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @GetMapping("/getAllCars")
//    @ResponseBody
    public String getAllCpu(@ModelAttribute CarModel carModel, Model model) {
        model.addAttribute("carModel", carModel);
        model.addAttribute("listOfCars",carsService.getAllCars());////convert iterator to list late
        return "car/allCars";
    }


    @GetMapping("/addCar")
    public String getFormToAddCar( @ModelAttribute CarModel carModel, Model model){

        model.addAttribute("carModel", carModel);
        model.addAttribute("brands", carsService.getCarBrands());
        model.addAttribute("carModels", carsService.getCarModels());
        model.addAttribute("bodyStyles",BodyStyle.values());
        model.addAttribute("manufactures", carsService.getManufactures());
        return "car/addCar";
    }

    /**
     * add new record to database
     * @param carModel - new record
     */
    @PostMapping("/addCar")
    public String  addCar(@ModelAttribute CarModel carModel){
        carsService.addNewCar(carModel);
        return "redirect:/cars/getAllCars";
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
    public String removeCar(@PathVariable("id") int id){
        carsService.removeById(id);
        return "result: car was successfully removed";
    }



}