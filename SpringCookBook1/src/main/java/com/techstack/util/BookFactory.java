package com.techstack.util;

import java.util.ArrayList;
import java.util.List;

import com.techstack.model.Author;
import com.techstack.model.Book;

public class BookFactory {

	public static List<Book> getBooks(){
		
		Author author = new Author();
		author.setFirstName("author_1");
		
		Book book = new Book();
		book.setIsbn("abcd");
		book.setDescription("desccc");
		book.setId(1990L);
		book.setAuthor(author);
		List<Book> bks = new ArrayList<>();
		bks.add(book);
		//author.setBooks(bks);
		return bks;
		
	}
}
