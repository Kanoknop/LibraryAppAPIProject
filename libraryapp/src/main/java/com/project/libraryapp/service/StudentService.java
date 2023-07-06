package com.project.libraryapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.libraryapp.model.StudentData;
import com.project.libraryapp.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<List<StudentData>> getStudent() {
        try{
            return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addStudent(StudentData student) {
        try{
            studentRepository.save(student);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateStudent(StudentData newStudent) {
        try{
            var old = studentRepository.findById(newStudent.getStudentId());
            var oldStudent = old.get();
            oldStudent.setStudentName(newStudent.getStudentName());
            oldStudent.setContact(newStudent.getContact());
            studentRepository.save(oldStudent);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        try{
            studentRepository.deleteById(id);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);           
        } catch (Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }
    
}
