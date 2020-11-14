package com.example.demo.controller;

import com.example.demo.entity.Manufacturers;
import com.example.demo.model.ManufacturerModel;
import com.example.demo.service.ManufacturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturersController {

    @Autowired
    private ManufacturersService manufacturersService;

    @GetMapping("addManufacturer")
    public String showFormToAddManufacturer(@ModelAttribute ManufacturerModel manufacturerModel, Model model){
        model.addAttribute("manufacturerModel",manufacturerModel);
        model.addAttribute("brands", manufacturersService.getCarBrands());
        return "addManufacturer";
    }

    @PostMapping("addManufacturer")
    public String addManufacturer(@ModelAttribute("manufacturerModel") ManufacturerModel manufacturerModel){
        //добавить проверку: нет ли такой производитель в базе
        manufacturersService.addManufacturer(manufacturerModel);
        return "home";
    }


}
