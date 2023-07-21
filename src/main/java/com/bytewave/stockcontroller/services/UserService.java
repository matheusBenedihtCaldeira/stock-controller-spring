package com.bytewave.stockcontroller.services;

import com.bytewave.stockcontroller.models.dto.ProductDTO;
import com.bytewave.stockcontroller.models.dto.UserDTO;
import com.bytewave.stockcontroller.models.entities.Product;
import com.bytewave.stockcontroller.models.entities.User;
import com.bytewave.stockcontroller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //Index all users
    public List<User> index(){
        return repository.findAll();
    }

    //Insert user
    public User insert(User data){
        return repository.insert(data);
    }

    public User fromDTO(UserDTO dataDTO){
        return new User(dataDTO.getId(), dataDTO.getName(), dataDTO.getEmail(), dataDTO.getPassword(), dataDTO.getKey());
    }
}
