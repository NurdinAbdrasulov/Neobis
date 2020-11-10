package com.example.demo.controller;

import com.example.demo.entity.Clients;
import com.example.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public Iterable<Clients> showAllClients(){
        return clientsService.getAllClients();
    }

    @GetMapping("/{id}")
    public Clients showClient(@PathVariable("id") int id){
        return clientsService.getClientById(id);
    }

}
