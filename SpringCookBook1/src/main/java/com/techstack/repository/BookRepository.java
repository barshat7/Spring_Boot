package com.techstack.repository;

import org.springframework.data.repository.CrudRepository;

import com.techstack.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	public Book findBookByIsbn(String isbn);
}
