package com.techstack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techstack.model.Book;
import com.techstack.repository.BookRepository;
import com.techstack.util.BookFactory;

@RestController
@RequestMapping("/book")
public class BookController {

	// CRUD -- Not using any service class
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Boolean> save(@RequestBody Book book){
		Book saved = null;
		try {
			saved= bookRepository.save(book);
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println("Book saved" +saved.getId());
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
	
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}
	@GetMapping("/isbn/{isbn}")
	public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
		
		Book book = bookRepository.findBookByIsbn(isbn);
		return book;
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		
		//List<Book> books = (List<Book>) bookRepository.findAll();
		List<Book> books = BookFactory.getBooks();
		return books;
	}
	
}
