package com.example.demo.controller;

import com.example.demo.entity.Employees;
import com.example.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public Iterable<Employees> showAllClients(){
        return employeesService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employees showEmployee(@PathVariable("id") int id){
        return employeesService.getEmployeeById(id);
    }
}
