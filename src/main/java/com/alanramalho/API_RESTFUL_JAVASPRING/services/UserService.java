package com.alanramalho.API_RESTFUL_JAVASPRING.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.repository.UserRepository;
import com.alanramalho.API_RESTFUL_JAVASPRING.services.ServicesExceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    public List<User> findAll() {
        return userRep.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
