package com.intelliatech.library_management.LibraryManagement.controllers;

import com.intelliatech.library_management.LibraryManagement.dto.SubjectDto;
import com.intelliatech.library_management.LibraryManagement.models.Subject;
import com.intelliatech.library_management.LibraryManagement.services.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

       @Autowired
        private SubjectService subjectService;
       private static final Logger log = LoggerFactory.getLogger(SubjectController.class);


       //Create new subject record
       @PostMapping("/create")
       public ResponseEntity<?> createSubject(@RequestBody SubjectDto subjectDto)
       {
              log.info("Request came on the CreateSubject Controller");

                Subject tempSubject = this.subjectService.createSubject(subjectDto);
                if(tempSubject != null)
                {
                       log.debug("subject successfully stored");
                       return ResponseEntity.status(HttpStatus.OK).body(tempSubject);
                }else{
                       log.error("Subject not created");
                       return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
                }

       }


       @GetMapping("/get/all")
       public ResponseEntity<?> getAllSubject()
       {
           log.info("Request came on the getAllSubject controller layer");
           List<Subject> listOfSubject = this.subjectService.getSubjects();
           return ResponseEntity.status(HttpStatus.OK).body(listOfSubject);

       }
}
