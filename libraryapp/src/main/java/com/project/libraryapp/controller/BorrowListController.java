package com.project.libraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.libraryapp.model.BorrowListData;
import com.project.libraryapp.service.BorrowListService;

@RestController
@RequestMapping("borrowList")
public class BorrowListController {
    
    @Autowired
    BorrowListService borrowListService;

    @PostMapping("create")
    public ResponseEntity<String> createBorrowList(@RequestParam Integer bookId, @RequestParam Integer studentId){
        return borrowListService.createBorrowList(bookId, studentId);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<List<BorrowListData>> getBorrowListById(@PathVariable int id){
        return borrowListService.getBorrowListById(id);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteBorrowList(@PathVariable int id){
        return borrowListService.deleteBorrowList(id);
    }

    @PostMapping("update")
    public ResponseEntity<String> updateBorrowList(@RequestBody BorrowListData borrowList){
        return borrowListService.updateBorrowList(borrowList);
    } 
}
