package com.techstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techstack.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {

	
}
