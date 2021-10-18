package com.intelliatech.library_management.LibraryManagement.controllers;

import com.intelliatech.library_management.LibraryManagement.dao.BookRepository;
import com.intelliatech.library_management.LibraryManagement.dto.BookAllocate;
import com.intelliatech.library_management.LibraryManagement.dto.BookDto;
import com.intelliatech.library_management.LibraryManagement.dto.ResponseClass;
import com.intelliatech.library_management.LibraryManagement.models.Book;
import com.intelliatech.library_management.LibraryManagement.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
     private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    private static final Logger log = LoggerFactory.getLogger(BookController.class);


    @PostMapping("/create")
    public ResponseEntity<?> createBookRecord(@RequestBody BookDto bookDto)
    {
             log.info("Request came on the create book controller.....");
             Book tempBook = this.bookService.createBook(bookDto);

             if(tempBook != null)
             {
                 log.debug("Record successfully inserted....");
                 return ResponseEntity.status(HttpStatus.OK).body(tempBook);
             }else{
                 log.error("record didn't create");
                 return ResponseEntity.status(HttpStatus.OK).build();
             }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getBooks()
    {
        log.info("Request came on the getBooks controller......");
        List<Book> listOfBook =  this.bookService.getBooks();
        log.debug("success");
        return ResponseEntity.status(HttpStatus.OK).body(listOfBook);
    }


    @PostMapping("/issue")
    public ResponseClass bookIssued(@RequestBody BookAllocate bookAllocate)
    {

        return this.bookService.issuedBookService(bookAllocate);
    }

    @GetMapping("/check")
    public ResponseEntity<?> check(@RequestBody BookAllocate bookAllocate)
    {
        Integer n = this.bookRepository.checkRecord(bookAllocate.getBookId(),bookAllocate.getStudentId());
        return ResponseEntity.status(HttpStatus.OK).body(n);
    }
}
