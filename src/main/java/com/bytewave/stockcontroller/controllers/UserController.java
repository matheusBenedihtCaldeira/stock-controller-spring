package com.bytewave.stockcontroller.controllers;

import com.bytewave.stockcontroller.models.dto.UserDTO;
import com.bytewave.stockcontroller.models.entities.User;
import com.bytewave.stockcontroller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    //Index all users
    @GetMapping
    public ResponseEntity<List<User>> index(){
        List<User> users = service.index();
        return ResponseEntity.ok().body(users);
    }

    //Insert a new user
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO dataDTO){
        User user = service.fromDTO(dataDTO);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

   //Find user by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //Delete user by id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Update user
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO data, @PathVariable String id){
        User userUpdated = service.fromDTO(data);
        userUpdated.setId(id);
        userUpdated = service.update(userUpdated);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userUpdated.getId()).toUri();
        return ResponseEntity.noContent().build();
    }
}