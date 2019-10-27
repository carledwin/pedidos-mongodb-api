package com.wordpress.carledwin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wordpress.carledwin.document.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
