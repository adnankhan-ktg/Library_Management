package com.intelliatech.library_management.LibraryManagement.service_impl;

import com.intelliatech.library_management.LibraryManagement.dao.BookRepository;
import com.intelliatech.library_management.LibraryManagement.dao.StudentRepository;
import com.intelliatech.library_management.LibraryManagement.dto.BookAllocate;
import com.intelliatech.library_management.LibraryManagement.dto.BookDto;
import com.intelliatech.library_management.LibraryManagement.dto.ResponseClass;
import com.intelliatech.library_management.LibraryManagement.models.Book;
import com.intelliatech.library_management.LibraryManagement.models.Student;
import com.intelliatech.library_management.LibraryManagement.services.BookService;
import com.intelliatech.library_management.LibraryManagement.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
     private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    @Override
    public Book createBook(BookDto bookDto) {

         Book book = new Book();
        BeanUtils.copyProperties(bookDto,book);
        book.setCurrentQuantity(book.getTotalQuantity());
//        book.setStudents(bookDto.getStudents());

        return this.bookRepository.save(book);
    }


    @Override
    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }


    @Override
    public ResponseClass issuedBookService(BookAllocate bookAllocate) {

        //create Object for Response
        ResponseClass response = new ResponseClass();

        //Check Record exists or not
         Integer recordCount = this.bookRepository.checkRecord(bookAllocate.getBookId(),bookAllocate.getStudentId());
         //Make object of student class
         Student temporaryStudent = new Student();

         //Fetch Student from DB by student primary key
         temporaryStudent =  this.studentRepository.findById(bookAllocate.getStudentId());

         //Make Object of Book class
        Book temporaryBook = this.bookRepository.findById(bookAllocate.getBookId());

        //Student exists or not
         if(temporaryStudent == null)
         {
             response.setMessage("student not found");
             response.setStatus(404);
             return  response;
         }
         else if(temporaryBook == null)
         {
             response.setMessage("Book not found");
             response.setStatus(404);
             return  response;
         }
         else if(recordCount > 0) //
         {
             response.setMessage("Book already allocated");
             response.setStatus(403);
             return response;
         }
         else if(temporaryStudent.getBookQuantity() >= 5)
         {
             response.setMessage("Student has reached the book limit");
             response.setStatus(409);
             return response;
         }
         else if(temporaryBook.getCurrentQuantity() <= 0)
         {
             response.setMessage("Desired book is not available now");
             response.setStatus(204);
             return response;
         }
         else{
             temporaryBook.setCurrentQuantity(temporaryBook.getCurrentQuantity() - 1);
             temporaryStudent.setBookQuantity(temporaryStudent.getBookQuantity() + 1);

             //create list type of students
             List<Student> listOfStudent = new ArrayList<>();
             listOfStudent.add(temporaryStudent);
             //add list of student in the book Object
             temporaryBook.setStudents(listOfStudent);

                List<Book> listOfBook = new ArrayList<>();
                listOfBook.add(temporaryBook);
                temporaryStudent.setBooks(listOfBook);
                this.studentRepository.save(temporaryStudent);

             this.bookRepository.save(temporaryBook);


             response.setMessage("Book Successfully issued");
             response.setStatus(200);
             return response;
         }

    }





    @Override
    public Book updateBook(Book book) {
        return this.bookRepository.save(book);


    }
}
