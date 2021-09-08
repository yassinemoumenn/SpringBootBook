package com.example.SpringBootBook.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.SpringBootBook.model.Book;
import com.example.SpringBootBook.repository.IBookRepository;
import com.example.SpringBootBook.service.Impl.IBookService;


public class BookService implements IBookService {
	
	  private final IBookRepository bookRepository;

	    public BookService(IBookRepository bookRepository)
	    {
	        this.bookRepository = bookRepository;
	    }

	@Override
	public Book saveBook(Book book) {
		 
		        book.setCreateTime(LocalDateTime.now());
		        return bookRepository.save(book);
		    }
	 @Override
	    public void deleteBook(Long id)
	    {
	        bookRepository.deleteById(id);
	    }

	    @Override
	    public List<Book> findAllBooks()
	    {
	        return bookRepository.findAll();
	    }

}
