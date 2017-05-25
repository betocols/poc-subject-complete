package com.example.pocsubject.rest;

import com.example.pocsubject.commons.AbstractController;
import com.example.pocsubject.rest.dto.SubjectComplete;
import com.example.pocsubject.rest.dto.SubjectProfessor;
import com.example.pocsubject.service.SubjectProfessorService;
import com.example.pocsubject.service.exception.SubjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("v1/subjects/professors")
public class SubjectProfessorController extends AbstractController {

    @Autowired
    private SubjectProfessorService subjectProfessorService;

    @RequestMapping(method = RequestMethod.POST)
    public void addProfessorToSubject(@RequestBody @Validated SubjectProfessor subjectProfessor) throws SubjectNotFoundException {
        subjectProfessorService.createSubjectProfessor(subjectProfessor);
    }

    @RequestMapping(value = "/{subjectId}", method = RequestMethod.GET)
    public SubjectComplete getSubjectProfessors(@PathVariable(value = "subjectId") Long subjectId) throws SubjectNotFoundException {
        return subjectProfessorService.getSubjectWithProfessors(subjectId);
    }

}
