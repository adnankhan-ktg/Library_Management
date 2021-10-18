package com.intelliatech.library_management.LibraryManagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    //Student private states...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_first_name")
    private String firstName;
    @Column(name = "student_last_name")
    private String lastName;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_weight")
    private double weight;
    @Column(name = "student_adult_status")
    private boolean adult;
    @Column(name = "student_gender")
    private String gender;
    @Column(name = "issued_book_quantity")
    private int bookQuantity = 0;

//    @ManyToMany(mappedBy = "students",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();
}






