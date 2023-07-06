package com.project.libraryapp.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "borrow_list")
public class BorrowListData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer borrowId;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "student_name")
    private String studentName;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "borrow_date")
    private LocalDate borrowDate;



    
}
