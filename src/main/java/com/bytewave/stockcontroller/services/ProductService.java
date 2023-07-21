package com.bytewave.stockcontroller.services;

import com.bytewave.stockcontroller.models.Product;
import com.bytewave.stockcontroller.repositories.ProductRepository;
import com.bytewave.stockcontroller.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //Index all products
    public List<Product> index(){
        return repository.findAll();
    }

    //Insert a new product
    public Product insert(Product data){
        return repository.insert(data);
    }

    //Find a product by id
    public Product findById(String id){
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    //Delete product
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }
}
