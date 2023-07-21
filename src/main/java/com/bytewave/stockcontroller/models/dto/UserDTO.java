package com.bytewave.stockcontroller.models.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    //Params
    private String id;
    private String name;
    private String email;
    private String password;
    private String key;

    //Constructor without parameters
    public UserDTO() {}

    //Constructor witho parameters
    public UserDTO(String id, String name, String email, String password, String key) {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
}