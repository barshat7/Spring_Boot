package com.techstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstack.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

	public List<Book> findByReader(String reader);
}
