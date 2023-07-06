package com.project.libraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.libraryapp.model.StudentData;
import com.project.libraryapp.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @GetMapping("getStudent")
    public ResponseEntity<List<StudentData>> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping("addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentData student){
        return studentService.addStudent(student);
    }

    @PostMapping("updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody StudentData student){
        return studentService.updateStudent(student);
    }

    @PostMapping("deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
