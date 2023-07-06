package com.project.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.libraryapp.model.BookData;

@Repository
public interface BookRepository extends JpaRepository<BookData, Integer>{
    
}
