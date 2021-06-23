package com.RestApiMongodbRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RestApiMongodbModel.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}

