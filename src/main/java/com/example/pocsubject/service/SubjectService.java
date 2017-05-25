package com.example.pocsubject.service;

import com.example.pocsubject.converter.SubjectConverter;
import com.example.pocsubject.domain.SubjectEntity;
import com.example.pocsubject.repository.SubjectRepository;
import com.example.pocsubject.rest.dto.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    @Autowired
    private SubjectConverter subjectConverter;

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject getSubject(Long id) {
        return subjectConverter.toDto(subjectRepository.findById(id));
    }

    public List<Subject> getAllSubject() {
        return subjectRepository.findAll().stream()
                .map(subjectEntity -> subjectConverter.toDto(subjectEntity)).collect(Collectors.toList());
    }

    public List<Subject> getListOfSubjects(List<Long> ids) {
        return subjectRepository.findByIdIn(ids).stream()
                .map(subjectEntity -> subjectConverter.toDto(subjectEntity)).collect(Collectors.toList());
    }

    public Subject createSubject(Subject subject) {
        SubjectEntity subjectEntity = subjectConverter.toEntity(subject);
        return subjectConverter.toDto(subjectRepository.save(subjectEntity));
    }

    public Subject updateSubject(Long id, Subject subject) {
        SubjectEntity subjectEntity = subjectRepository.findById(id);
        subjectEntity.setName(subject.getName());
        return subjectConverter.toDto(subjectRepository.save(subjectEntity));
    }
}
