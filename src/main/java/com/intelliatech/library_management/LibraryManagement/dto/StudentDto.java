package com.intelliatech.library_management.LibraryManagement.dto;

import com.intelliatech.library_management.LibraryManagement.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private String gender;
    private boolean adult;
    private int bookQuantity;
//    private List<Book> book;


}
