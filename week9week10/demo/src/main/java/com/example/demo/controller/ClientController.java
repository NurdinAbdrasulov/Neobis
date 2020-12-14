package com.example.demo.controller;

import com.example.demo.entity.Clients;
import com.example.demo.model.ClientModel;
import com.example.demo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@PreAuthorize("hasAuthority('clientMapping')")
public class ClientController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping("getAll")
    public Iterable<Clients> showAllClients(){
        return clientsService.getAllClients();
    }

    @GetMapping("get/{id}")
    public Clients showClient(@PathVariable("id") int id){
        return clientsService.getClientById(id);
    }

    @PostMapping("add")
    public String addNewClient(@RequestBody ClientModel clientModel){
        return clientsService.addNewClient(clientModel);
    }

    @DeleteMapping("delete/{id}")
    public String updateClient(@PathVariable int id){
        clientsService.deleteById(id);
        return "result: deleted";
    }
}
