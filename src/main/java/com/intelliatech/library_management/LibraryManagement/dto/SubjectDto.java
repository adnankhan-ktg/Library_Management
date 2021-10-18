package com.intelliatech.library_management.LibraryManagement.dto;

import com.intelliatech.library_management.LibraryManagement.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

    private int id;
    private String name;
    private List<Book> book;
}
