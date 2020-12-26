package com.example.demo.controller;

import com.example.demo.entity.enums.Gender;
import com.example.demo.entity.enums.Position;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String registration(@ModelAttribute EmployeeModel employeeModel, Model model){
        model.addAttribute("employeeModel",employeeModel);
        model.addAttribute("genders", Gender.values());
        model.addAttribute("positions", Position.values());
        return "registration";
    }

    @PostMapping
    public String registerEmployee(@ModelAttribute("employeeModel") EmployeeModel employeeModel, Model model, RedirectAttributes redirectAttributes){
        if (registrationService.isLoginExists(employeeModel.getLogin())) {
            model.addAttribute("message", "Этот логин уже существует! Введите другой логин.");
            model.addAttribute("employeeModel", employeeModel);
            model.addAttribute("genders", Gender.values());
            model.addAttribute("positions", Position.values());
            return "registration";
        }

        registrationService.register(employeeModel);
        redirectAttributes.addAttribute("registrationMessage","Вы успешно зарегистрировались!" );
        return "redirect:/login";
    }
}
