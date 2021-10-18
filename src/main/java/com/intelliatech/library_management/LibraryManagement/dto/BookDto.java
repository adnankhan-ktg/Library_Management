package com.intelliatech.library_management.LibraryManagement.dto;


import com.intelliatech.library_management.LibraryManagement.models.Student;
import com.intelliatech.library_management.LibraryManagement.models.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private int id;
    private String name;
    private boolean available;
    private int totalQuantity;
    private int currentQuantity;
    private List<Student> students;
    private Subject subject;
}
