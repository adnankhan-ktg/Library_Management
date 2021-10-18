package com.intelliatech.library_management.LibraryManagement.dao;

import com.intelliatech.library_management.LibraryManagement.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

}
