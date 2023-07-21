package com.bytewave.stockcontroller.controllers;

import com.bytewave.stockcontroller.models.Product;
import com.bytewave.stockcontroller.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;


    //Index products
    @GetMapping
    public ResponseEntity<List<Product>> index(){
        List<Product> products = service.index();
        return ResponseEntity.ok().body(products);
    }
    //Insert user
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product data){
        service.insert(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //Find product by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Delete product by id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}