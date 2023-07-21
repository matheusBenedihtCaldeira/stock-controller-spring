package com.bytewave.stockcontroller.services;

import com.bytewave.stockcontroller.models.dto.ProductDTO;
import com.bytewave.stockcontroller.models.dto.UserDTO;
import com.bytewave.stockcontroller.models.entities.Product;
import com.bytewave.stockcontroller.models.entities.User;
import com.bytewave.stockcontroller.repositories.UserRepository;
import com.bytewave.stockcontroller.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    //Find user by id
    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }

    //Delete user by id
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    //Update user
    public User update(User data){
        User userUpdated = findById(data.getId());
        updateData(userUpdated, data);
        return repository.save(userUpdated);
    }

    private void updateData(User userUpdated, User data) {
        userUpdated.setName(data.getName());
        userUpdated.setEmail(data.getEmail());
        userUpdated.setKey(data.getKey());
        userUpdated.setPassword(data.getPassword());
    }
}