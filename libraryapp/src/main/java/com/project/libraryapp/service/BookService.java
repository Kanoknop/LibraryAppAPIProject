package com.project.libraryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.libraryapp.model.BookData;
import com.project.libraryapp.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<List<BookData>> getBook() {
        try{
            return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addBook(BookData book) {
        try{
            bookRepository.save(book);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateBook(BookData newBook) {
        try{
            var old = bookRepository.findById(newBook.getBookId());
            var oldBook = old.get();
            oldBook.setBookName(newBook.getBookName());
            oldBook.setStatus(newBook.getStatus());
            oldBook.setStudentId(newBook.getStudentId());
            bookRepository.save(oldBook);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteBook(Integer id) {
        try{
            bookRepository.deleteById(id);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);           
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
}
