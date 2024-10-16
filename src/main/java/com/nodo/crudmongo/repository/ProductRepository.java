package com.nodo.crudmongo.repository;

import com.nodo.crudmongo.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Long> {
}
