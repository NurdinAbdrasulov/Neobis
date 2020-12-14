package com.example.demo.controller;

import com.example.demo.entity.Employees;
import com.example.demo.model.AuthenticationModel;
import com.example.demo.service.EmployeesService;
import com.example.demo.service.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final EmployeesService employeesService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, EmployeesService employeesService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.employeesService = employeesService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationModel request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            Employees user = employeesService.getEmployeeByLogin(request.getUsername());
            if( user == null)
                new UsernameNotFoundException("User doesn't exists");

            String token = jwtTokenProvider.createToken(request.getUsername(), user.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getUsername());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            System.out.println(e);
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }


    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}






/*
package com.example.demo.controller;


import com.example.demo.entity.Employees;
import com.example.demo.model.AuthenticationModel;
import com.example.demo.service.EmployeesService;
import com.example.demo.service.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private EmployeesService employeesService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, EmployeesService employeesService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.employeesService = employeesService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationModel model) {
        System.out.println("_______________post /login__________");
        try {
            String username = model.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, model.getPassword()));
            Employees user = employeesService.getEmployeeByLogin(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRole());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            System.out.println("_______________post /login______okkkkk____");

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
*/
