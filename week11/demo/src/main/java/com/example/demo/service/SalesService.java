package com.example.demo.service;

import com.example.demo.entity.Sales;
import com.example.demo.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    SalesRepository salesRepository;

    public Iterable<Sales> getAllSales(){
        return salesRepository.findAll();
    }

    public Sales getSaleById(int id){
        Optional<Sales> sale = salesRepository.findById(id);
        Sales res = sale.get();
        return res;
    }


}
