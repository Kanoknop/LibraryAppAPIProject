package com.project.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.libraryapp.model.StudentData;

@Repository
public interface StudentRepository extends JpaRepository<StudentData, Integer> {
    
}
