package com.example.demo.service;

import com.example.demo.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private EmployeesService employeesService;

    public void register(EmployeeModel employeeModel){
        employeesService.addNewEmployee(employeeModel);
    }

    public boolean isLoginExists(String login) {
        return employeesService.getEmployeeByLogin(login) != null;
    }
}
