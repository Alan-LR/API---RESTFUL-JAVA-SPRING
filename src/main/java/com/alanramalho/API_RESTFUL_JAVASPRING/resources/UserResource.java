package com.alanramalho.API_RESTFUL_JAVASPRING.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    // @RequestMapping(method = RequestMethod.GET) ou
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list1 = userService.findAll();
        System.out.println(list1);
        return ResponseEntity.ok().body(list1);

    }
}
