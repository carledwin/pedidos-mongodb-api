package com.wordpress.carledwin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wordpress.carledwin.document.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
