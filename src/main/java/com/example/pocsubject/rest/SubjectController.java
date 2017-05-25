package com.example.pocsubject.rest;

import com.example.pocsubject.commons.AbstractController;
import com.example.pocsubject.rest.dto.Subject;
import com.example.pocsubject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("v1/subjects")
@RequiredArgsConstructor
@Slf4j
public class SubjectController  extends AbstractController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject getSubject(@PathVariable(value = "id") Long id) {
        return subjectService.getSubject(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Subject> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @RequestMapping(value = "subjects_list", method = RequestMethod.GET)
    public List<Subject> getListOfSubjects(@RequestParam(value = "ids") List<Long> ids) {
        return subjectService.getListOfSubjects(ids);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Subject updateSubject(@PathVariable(value = "id") Long id, @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }
}
