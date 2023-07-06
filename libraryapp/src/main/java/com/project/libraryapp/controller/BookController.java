package com.project.libraryapp.controller;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.libraryapp.model.BookData;
import com.project.libraryapp.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {
    
    @Autowired
    BookService bookService;

    @GetMapping("getBook")
    public ResponseEntity<List<BookData>> getBook(){
        return bookService.getBook();
    }

    @PostMapping("addBook")
    public ResponseEntity<String> addBook(@RequestBody BookData book){
        return bookService.addBook(book);
    }

    @PostMapping("updateBook")
    public ResponseEntity<String> updateBook(@RequestBody BookData book){
        return bookService.updateBook(book);
    }

    @PostMapping("deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
