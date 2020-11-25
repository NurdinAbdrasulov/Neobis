package com.example.demo.controller;

import com.example.demo.entity.Employees;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@PreAuthorize("hasAuthority('employeesMapping')")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("getAll")
    public Iterable<Employees> showAllClients(){
        return employeesService.getAllEmployees();
    }

    @GetMapping("get/{id}")
    public Employees showEmployee(@PathVariable("id") int id){
        return employeesService.getEmployeeById(id);
    }

    @PostMapping("add")
    public String addNewEmployee(@ModelAttribute EmployeeModel model){
        return employeesService.addNewEmployee(model);
    }

    @PutMapping("update/{id}")
    public String update(@PathVariable int id, @ModelAttribute EmployeeModel model){
        return employeesService.update(id, model);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        employeesService.delete(id);
        return "result: success";//////////////
    }
}
