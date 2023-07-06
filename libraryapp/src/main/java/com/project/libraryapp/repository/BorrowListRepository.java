package com.project.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.libraryapp.model.BorrowListData;

@Repository
public interface BorrowListRepository extends JpaRepository<BorrowListData,Integer> {
    
}
