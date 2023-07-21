package com.bytewave.stockcontroller.controllers;

import com.bytewave.stockcontroller.models.Product;
import com.bytewave.stockcontroller.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    //Index products
    @GetMapping
    public ResponseEntity<List<Product>> index(){
        Product p1 = new Product("1", "Monitor Gamer", "Monitor Gamer 125Hz", 1200.0, 230);
        List<Product> list = new ArrayList<>(Arrays.asList(p1));
        return ResponseEntity.ok().body(list);
    }
}
