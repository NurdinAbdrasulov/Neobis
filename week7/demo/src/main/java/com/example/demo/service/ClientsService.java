package com.example.demo.service;

import com.example.demo.entity.Clients;
import com.example.demo.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public Iterable<Clients> getAllClients(){
        Iterable<Clients> allClients = clientsRepository.findAll();
        return allClients;
    }
    
    public Clients getClientById(int id){
        Optional<Clients> client = clientsRepository.findById(id);
        Clients res =client.get();
        return res;
    }
}
