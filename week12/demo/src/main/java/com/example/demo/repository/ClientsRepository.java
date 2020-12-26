package com.example.demo.repository;

import com.example.demo.entity.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Integer> {
    Clients findByLoginIgnoreCase(String login);

}
