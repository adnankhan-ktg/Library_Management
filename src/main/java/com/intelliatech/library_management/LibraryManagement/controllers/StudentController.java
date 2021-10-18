package com.intelliatech.library_management.LibraryManagement.controllers;

import com.intelliatech.library_management.LibraryManagement.dao.BookRepository;
import com.intelliatech.library_management.LibraryManagement.dao.StudentRepository;
import com.intelliatech.library_management.LibraryManagement.dto.BookAllocate;
import com.intelliatech.library_management.LibraryManagement.dto.StudentDto;
import com.intelliatech.library_management.LibraryManagement.models.Book;
import com.intelliatech.library_management.LibraryManagement.models.Student;
import com.intelliatech.library_management.LibraryManagement.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
     private StudentRepository studentRepository;
    @Autowired
     private StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);




    //Create new student
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto)
    {

        System.out.println(studentDto);
          log.info("Request came on the createStudent controller class");
          Student student = this.studentService.createStudent(studentDto);

          if(student != null)
          {
              log.debug("student successfully created");
              return ResponseEntity.status(HttpStatus.OK).body(student);
          }else{
              log.error("student not created");
              return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
          }

    }


    //Get all student
    @GetMapping("/get/all")
    public ResponseEntity<?> getStudents()
    {
        log.info("Request came on the getStudents controller.");

        List<Student> listOfStudent = this.studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(listOfStudent);

    }



    //Get student by primary key
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id)
    {
         log.info("Request came on the getStudent by Id controller");
         Student tempStudent = this.studentService.getStudent(id);
         if(tempStudent != null)
         {
             log.debug("student found");
             return ResponseEntity.status(HttpStatus.OK).body(tempStudent);
         }else{
               log.error("student not found");
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
    }



}
