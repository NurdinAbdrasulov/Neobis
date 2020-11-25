package com.example.demo.service;

import com.example.demo.entity.Clients;
import com.example.demo.model.ClientModel;
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

    public String addNewClient(ClientModel model) {
        if(model.getFio() != null && model.getGender() != null && model.getDateOfBirth() != null) {
            Clients client = new Clients();
            client.setFio(model.getFio());
            client.setGender(model.getGender());
            client.setAddress(model.getAddress());
            client.setDateOfBirth(model.getDateOfBirth());
            client.setPhoneNumber(model.getPhoneNumber());
            client.setRegistrationDate(model.getRegistrationDate());

            clientsRepository.save(client);
            return "result: success";
        }
        return "result: failed";

    }

    public Clients getClientByLogin(String login){
        return clientsRepository.findByLoginIgnoreCase(login);
    }

    public void deleteById(int id) {
        clientsRepository.deleteById(id);
    }
}
