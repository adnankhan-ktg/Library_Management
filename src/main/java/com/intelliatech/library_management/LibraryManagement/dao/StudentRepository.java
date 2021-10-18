package com.intelliatech.library_management.LibraryManagement.dao;

import com.intelliatech.library_management.LibraryManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select book_quantity from student s where s.student_id = ?",nativeQuery = true)
    Integer getBookQuantity(Integer student_id);

     public Student findById(int id);
}
