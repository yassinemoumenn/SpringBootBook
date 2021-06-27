package com.RestApiMongodb.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RestApiMongodb.Model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}

