package com.intelliatech.library_management.LibraryManagement.services;

import com.intelliatech.library_management.LibraryManagement.dto.SubjectDto;
import com.intelliatech.library_management.LibraryManagement.models.Subject;

import java.util.List;

public interface SubjectService {

    Subject createSubject(SubjectDto subjectDto);
    List<Subject> getSubjects();
}
