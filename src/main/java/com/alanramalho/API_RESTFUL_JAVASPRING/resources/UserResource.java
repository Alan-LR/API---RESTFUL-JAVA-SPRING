package com.alanramalho.API_RESTFUL_JAVASPRING.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.dto.UserDTO;
import com.alanramalho.API_RESTFUL_JAVASPRING.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    // @RequestMapping(method = RequestMethod.GET) ou
    // rota com o a senha do usuário privada
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    // puxando todas as informações do usuário (até a senha - rota para gerentes)
    @GetMapping("/verifyUsers")
    public ResponseEntity<List<User>> findEmail() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
