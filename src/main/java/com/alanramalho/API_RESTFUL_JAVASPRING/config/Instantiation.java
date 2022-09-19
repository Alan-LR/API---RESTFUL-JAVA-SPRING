package com.alanramalho.API_RESTFUL_JAVASPRING.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.Post;
import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;
import com.alanramalho.API_RESTFUL_JAVASPRING.dto.AuthorDTO;
import com.alanramalho.API_RESTFUL_JAVASPRING.repository.PostRepository;
import com.alanramalho.API_RESTFUL_JAVASPRING.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private PostRepository postRep;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRep.deleteAll();
        postRep.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com", "ma2254");
        User alex = new User(null, "Alex Green", "alex@gmail.com", "ale899");
        User bob = new User(null, "Bob Grey", "bob@gmail.com", "bob33@");

        userRep.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo, abraços!",
                new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje", new AuthorDTO(maria));

        postRep.saveAll(Arrays.asList(post1, post2));
    }

}
