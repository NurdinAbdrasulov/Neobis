package com.example.demo.service;

import com.example.demo.entity.Employees;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Iterable<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Employees getEmployeeById(int id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        Employees res = employee.get();
        return res;
    }
}
