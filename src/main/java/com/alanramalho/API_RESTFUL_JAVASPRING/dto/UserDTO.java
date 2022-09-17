package com.alanramalho.API_RESTFUL_JAVASPRING.dto;

import java.io.Serializable;
import java.util.Optional;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private String senha;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        senha = "******";
    }

    public UserDTO(Optional<User> obj) {
        id = obj.get().getId();
        name = obj.get().getName();
        email = obj.get().getEmail();
        senha = "******";
    }

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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
