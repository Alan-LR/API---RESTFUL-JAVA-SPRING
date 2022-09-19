package com.alanramalho.API_RESTFUL_JAVASPRING.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alanramalho.API_RESTFUL_JAVASPRING.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // Consulta simple com @Query MongoDB
    @Query("{'title': { $regex: ?0, $options: 'i'} }")
    List<Post> searchTitle(String text);

    // vai buscar todos os posts, ignorando camel case
    List<Post> findByTitleContainingIgnoreCase(String text);

    // Consulta com varios criterios - a:396
    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ {'title': { $regex: ?0, $options: 'i'} }, {'body': { $regex: ?0, $options: 'i'} }, {'comments.text': { $regex: ?0, $options: 'i'} } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
