package com.example.demo.repository;

import com.example.demo.entity.Manufacturers;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturesRepository extends CrudRepository<Manufacturers, Integer> {
}
