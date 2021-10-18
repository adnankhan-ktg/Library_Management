package com.intelliatech.library_management.LibraryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private int id;
    @Column(name = "subject_name")
     private String name;

    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    private List<Book> book;


}
