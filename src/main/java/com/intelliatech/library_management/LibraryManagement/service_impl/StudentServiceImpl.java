package com.intelliatech.library_management.LibraryManagement.service_impl;

import com.intelliatech.library_management.LibraryManagement.dao.StudentRepository;
import com.intelliatech.library_management.LibraryManagement.dto.StudentDto;
import com.intelliatech.library_management.LibraryManagement.models.Book;
import com.intelliatech.library_management.LibraryManagement.models.Student;
import com.intelliatech.library_management.LibraryManagement.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
  private StudentRepository studentRepository;


    @Override
    public Student createStudent(StudentDto student) {


         Student  tempStudent = new Student();
            BeanUtils.copyProperties(student,tempStudent);
//            List<Book> bookAList = student.getBook();
//        tempStudent.setBooks(bookAList);
        System.out.println("check  "+tempStudent);

        return this.studentRepository.save(tempStudent);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student getStudent(int id) {
        return this.studentRepository.findById(id);
    }
}
