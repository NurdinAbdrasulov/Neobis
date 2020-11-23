package com.example.demo.controller;

import com.example.demo.entity.Manufacturers;
import com.example.demo.model.ManufacturerModel;
import com.example.demo.service.ManufacturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturersController {

    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping("/getAll")
    public Iterable<Manufacturers> getAllManufacturers(){
       Iterable<Manufacturers> values = manufacturersService.getAllManufactures();
        return values;
    }

    @GetMapping("/get/{id}")
    public Optional<Manufacturers> getManufacturer(@PathVariable int id){
        return manufacturersService.getManufactureById(id);
    }

    @PostMapping("/add")
    public String addManufacturer(@ModelAttribute("manufacturerModel") ManufacturerModel manufacturerModel){
        //добавить проверку: нет ли такой производитель в базе
        manufacturersService.addManufacturer(manufacturerModel);
        return "{\"result\": success}";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute ManufacturerModel manufacturerModel){
        manufacturersService.update(id, manufacturerModel);
        return "{\"result\": success}";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        manufacturersService.delete(id);
        return "{\"result\": success}";
    }


}
