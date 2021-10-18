package com.intelliatech.library_management.LibraryManagement.services;

import com.intelliatech.library_management.LibraryManagement.dto.BookAllocate;
import com.intelliatech.library_management.LibraryManagement.dto.BookDto;
import com.intelliatech.library_management.LibraryManagement.dto.ResponseClass;
import com.intelliatech.library_management.LibraryManagement.models.Book;

import java.util.List;

public interface BookService {

    Book createBook(BookDto bookDto);
    List<Book> getBooks();
    ResponseClass issuedBookService(BookAllocate bookAllocate);
    Book updateBook(Book book);
}
