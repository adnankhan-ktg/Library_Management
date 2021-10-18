package com.intelliatech.library_management.LibraryManagement.dao;

import com.intelliatech.library_management.LibraryManagement.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

      Book findById(int id);
//      @Query(value = "SELECT count(*) from books_students bs where bs.book_id= :book_id and bs.student_id = :student_id ",nativeQuery = true)
//      Integer checkRecord(Integer book_id,Integer student_id);
      @Query(value = "SELECT count(*) FROM books_students where book_id= ?1 AND student_id= ?2",nativeQuery = true)
int checkRecord(int book_id, int student_id);


}
