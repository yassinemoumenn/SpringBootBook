package com.example.SpringBootBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootBook.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
