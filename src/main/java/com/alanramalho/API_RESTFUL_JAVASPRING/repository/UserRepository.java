package com.alanramalho.API_RESTFUL_JAVASPRING.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
