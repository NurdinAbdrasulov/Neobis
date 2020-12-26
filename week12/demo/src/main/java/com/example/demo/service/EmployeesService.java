package com.example.demo.service;

import com.example.demo.entity.Employees;
import com.example.demo.entity.enums.Role;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Employees getEmployeeById(int id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        Employees res = employee.get();
        return res;
    }

    public String addNewEmployee(EmployeeModel employeeModel){
        String result = "result: failed";
        if(employeeModel.getLogin() != null && employeeModel.getPassword() != null) {
            Employees employee = new Employees();
            employee.setFio(employeeModel.getFio());
            employee.setPosition(employeeModel.getPosition());
            employee.setGender(employeeModel.getGender());
            employee.setAddress(employeeModel.getAddress());
            employee.setPhoneNumber(employeeModel.getPhoneNumber());
            employee.setLogin(employeeModel.getLogin());
            employee.setPassword(passwordEncoder.encode(employeeModel.getPassword()));
            employee.setRole(Role.ADMIN);//////типо по умолчанию
            employeesRepository.save(employee);
            result = "result: success";
        }
        return result;
    }

    public Employees getEmployeeByLogin(String login) {
        return employeesRepository.findByLoginIgnoreCase(login);
    }

    public String update(int id, EmployeeModel model) {
        String result = "result: failed";

        Optional<Employees> optional = employeesRepository.findById(id);
        if(optional.isPresent() && model.getLogin() != null && model.getLogin() != null) {
            Employees employee = optional.get();
            employee.setFio(model.getFio());
            employee.setAddress(model.getAddress());
            employee.setGender(model.getGender());
            employee.setPhoneNumber(model.getPhoneNumber());
            employee.setPosition(model.getPosition());
            employee.setLogin(model.getLogin());
            employee.setPassword(passwordEncoder.encode(model.getPassword()));

            employeesRepository.save(employee);
            result = "result: success";
        }

        return result;
    }

    public void delete(int id) {
        employeesRepository.deleteById(id);
    }
}
