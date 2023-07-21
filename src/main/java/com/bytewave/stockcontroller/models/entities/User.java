package com.bytewave.stockcontroller.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    //Params
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String key;

    //Constructor without parameters
    public User() {}


    //Constructor with parameters
    public User(String id, String name, String email, String password, String key) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.key = key;
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    //Equals and HashCode for id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}