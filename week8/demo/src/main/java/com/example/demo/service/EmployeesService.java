package com.example.demo.service;

import com.example.demo.entity.Employees;
import com.example.demo.model.EmployeeModel;
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

    public void addNewEmployee(EmployeeModel employeeModel){
        Employees employee = new Employees();
        employee.setFio(employeeModel.getFio());
        employee.setPosition(employeeModel.getPosition());
        employee.setGender(employeeModel.getGender());
        employee.setAddress(employeeModel.getAddress());
        employee.setPhoneNumber(employeeModel.getPhoneNumber());
        employee.setLogin(employeeModel.getLogin());
        employee.setPassword(employeeModel.getPassword());
        employeesRepository.save(employee);
    }

    public Employees getEmployeeByLogin(String login) {
        return employeesRepository.findByLoginIgnoreCase(login);
    }
}
