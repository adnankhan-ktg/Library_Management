package com.intelliatech.library_management.LibraryManagement.services;

import com.intelliatech.library_management.LibraryManagement.dto.StudentDto;
import com.intelliatech.library_management.LibraryManagement.models.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentDto student);
    List<Student> getStudents();
    Student updateStudent(Student studentDto);
    Student getStudent(int id);

}
