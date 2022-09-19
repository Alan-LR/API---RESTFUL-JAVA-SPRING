package com.alanramalho.API_RESTFUL_JAVASPRING.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // vai buscar todos os posts, ignorando camel case
    List<Post> findByTitleContainingIgnoreCase(String text);
}
