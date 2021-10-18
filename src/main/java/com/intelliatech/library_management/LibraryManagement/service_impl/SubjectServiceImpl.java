package com.intelliatech.library_management.LibraryManagement.service_impl;

import com.intelliatech.library_management.LibraryManagement.dao.SubjectRepository;
import com.intelliatech.library_management.LibraryManagement.dto.SubjectDto;
import com.intelliatech.library_management.LibraryManagement.models.Book;
import com.intelliatech.library_management.LibraryManagement.models.Subject;
import com.intelliatech.library_management.LibraryManagement.services.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(SubjectDto subjectDto) {
        Subject tempSubject = new Subject();
        List<Book> bookList = subjectDto.getBook();
        BeanUtils.copyProperties(subjectDto,tempSubject);
        tempSubject.setBook(bookList);
        return this.subjectRepository.save(tempSubject);
    }

    @Override
    public List<Subject> getSubjects() {
        return this.subjectRepository.findAll();
    }
}
