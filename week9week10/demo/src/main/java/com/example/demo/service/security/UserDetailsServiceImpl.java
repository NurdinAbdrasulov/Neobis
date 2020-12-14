package com.example.demo.service.security;

import com.example.demo.entity.Clients;
import com.example.demo.entity.Employees;
import com.example.demo.repository.EmployeesRepository;
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
    private EmployeesRepository employeesRepository;

    @Autowired
    private ClientsService clientsService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employees user = employeesRepository.findByLoginIgnoreCase(login);

        if (user == null) {
            Clients client = clientsService.getClientByLogin(login);

            if(client == null)
                throw new UsernameNotFoundException("No user found with login: " + login);
            return new SecurityUser(client.getLogin(),client.getPassword(),true, client.getRole().getAuthorities());
        }
        return new SecurityUser(user.getLogin(), user.getPassword(), true, user.getRole().getAuthorities());

    }

}
