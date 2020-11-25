package com.example.demo.service.security;

import com.example.demo.entity.Clients;
import com.example.demo.entity.Employees;
import com.example.demo.service.ClientsService;
import com.example.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private ClientsService clientsService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employees user = employeesService.getEmployeeByLogin(login);

        if (user == null) {
            Clients client = clientsService.getClientByLogin(login);

            if(client == null)
                throw new UsernameNotFoundException("No user found with login: " + login);

            return new org.springframework.security.core.userdetails.User(client.getLogin(), client.getPassword(),
                    true, true, true, true, client.getRole().getAuthorities());

        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, user.getRole().getAuthorities());
    }

}
