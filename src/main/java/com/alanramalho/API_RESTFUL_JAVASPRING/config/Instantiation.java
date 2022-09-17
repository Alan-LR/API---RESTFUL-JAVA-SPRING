package com.alanramalho.API_RESTFUL_JAVASPRING.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRep;

    @Override
    public void run(String... args) throws Exception {

        userRep.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com", "ma2254");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "ale899");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "bob33@");
        userRep.saveAll(Arrays.asList(maria, alex, bob));
    }

}
