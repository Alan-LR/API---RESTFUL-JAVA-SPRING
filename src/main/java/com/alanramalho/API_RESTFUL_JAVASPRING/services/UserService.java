package com.alanramalho.API_RESTFUL_JAVASPRING.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.dto.UserDTO;
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

    public User insert(User obj) {
        return userRep.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        userRep.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRep.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setSenha(obj.getSenha());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getSenha());
    }

}
