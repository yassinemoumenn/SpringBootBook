package com.example.SpringBootBook.service.Impl;

import java.util.List;

import com.example.SpringBootBook.model.Book;


public interface IBookService {

	
	    Book saveBook(Book book);

	    void deleteBook(Long id);

	    List<Book> findAllBooks();
	}
