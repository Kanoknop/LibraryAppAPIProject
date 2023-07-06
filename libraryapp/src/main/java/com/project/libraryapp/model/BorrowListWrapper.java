package com.project.libraryapp.model;

import lombok.Data;

@Data
public class BorrowListWrapper {
    private Integer borrowId;
    private BookData bookId;
    private StudentData studentId;
    private String returnDate;

    public BorrowListWrapper(Integer borrowId, BookData bookId, StudentData studentId, String returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.returnDate = returnDate;
    }
}
