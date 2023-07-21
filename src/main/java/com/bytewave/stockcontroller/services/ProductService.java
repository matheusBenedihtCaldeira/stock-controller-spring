package com.bytewave.stockcontroller.services;

import com.bytewave.stockcontroller.models.Product;
import com.bytewave.stockcontroller.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> index(){
        return repository.findAll();
    }


    public Product insert(Product data){
        return repository.insert(data);
    }
}
