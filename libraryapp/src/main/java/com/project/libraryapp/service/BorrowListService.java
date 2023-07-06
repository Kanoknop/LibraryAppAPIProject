package com.project.libraryapp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.libraryapp.model.BookData;
import com.project.libraryapp.model.BorrowListData;
import com.project.libraryapp.model.BorrowListWrapper;
import com.project.libraryapp.model.StudentData;
import com.project.libraryapp.repository.BookRepository;
import com.project.libraryapp.repository.BorrowListRepository;
import com.project.libraryapp.repository.StudentRepository;

@Service
public class BorrowListService {
    
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowListRepository borrowListRepository;
    public ResponseEntity<String> createBorrowList(int bookId, int studentId){
        try{
            Optional<BookData> book = bookRepository.findById(bookId);
            Optional<StudentData> student = studentRepository.findById(studentId);
            if (book.isPresent() && student.isPresent()){
                var bookList = book.get();
                var studentList = student.get();
                BorrowListData borrowList = new BorrowListData();
                borrowList.setBookId(bookList.getBookId());
                borrowList.setStudentId(studentList.getStudentId());

                LocalDate today = LocalDate.now();
                LocalDate returnDate = today.plus(2, ChronoUnit.WEEKS);

                borrowList.setReturnDate(returnDate);
                borrowList.setBorrowDate(today);
                borrowList.setBookName(bookList.getBookName());
                borrowList.setStudentName(studentList.getStudentName());
                borrowListRepository.save(borrowList);

                return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Fail", HttpStatus.CREATED);

    }


    public ResponseEntity<List<BorrowListData>> getBorrowListById(int id) {
        try{
            Optional<BorrowListData> borrowListdata = borrowListRepository.findById(id);
            if(borrowListdata.isPresent()){
                List<BorrowListData> borrowList = new ArrayList<>();
                borrowList.add(borrowListdata.get());
                return new ResponseEntity<>(borrowList, HttpStatus.OK);
            }

        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> deleteBorrowList(int id) {
        try{
            borrowListRepository.deleteById(id);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);           
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateBorrowList(BorrowListData newBorrow){
        try{
            Optional<BookData> book = bookRepository.findById(newBorrow.getBookId());
            Optional<StudentData> student = studentRepository.findById(newBorrow.getStudentId());
            if (book.isPresent() && student.isPresent()){
                var oldBorrowResult = borrowListRepository.findById(newBorrow.getBorrowId());
                var oldBorrow = oldBorrowResult.get();
                var bookList = book.get();
                var studentList = student.get();
                oldBorrow.setBookId(newBorrow.getBookId());
                oldBorrow.setBookName(bookList.getBookName());
                oldBorrow.setStudentId(newBorrow.getStudentId());
                oldBorrow.setStudentName(studentList.getStudentName());
                oldBorrow.setBorrowDate(oldBorrow.getBorrowDate());
                oldBorrow.setReturnDate(newBorrow.getReturnDate());
                borrowListRepository.save(oldBorrow);
                return new ResponseEntity<>("Update Success", HttpStatus.OK);
            }


        }catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }


}
