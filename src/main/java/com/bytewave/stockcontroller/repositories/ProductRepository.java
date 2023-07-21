package com.bytewave.stockcontroller.repositories;

import com.bytewave.stockcontroller.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
