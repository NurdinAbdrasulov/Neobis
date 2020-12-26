package com.example.demo.controller;

import com.example.demo.entity.Sales;
import com.example.demo.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    SalesService salesService;

    @GetMapping
    public Iterable<Sales> showAllSales(){
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sales showSale(@PathVariable("id") int id){
        return salesService.getSaleById(id);
    }
}
