package com.example.pocsubject.service;

import com.example.pocsubject.converter.SubjectProfessorConverter;
import com.example.pocsubject.domain.SubjectEntity;
import com.example.pocsubject.repository.SubjectProfessorRepository;
import com.example.pocsubject.repository.SubjectRepository;
import com.example.pocsubject.rest.dto.Professor;
import com.example.pocsubject.rest.dto.SubjectComplete;
import com.example.pocsubject.rest.dto.SubjectProfessor;
import com.example.pocsubject.service.exception.ProfessorNotFoundException;
import com.example.pocsubject.service.exception.SubjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectProfessorService {

    @Autowired
    private SubjectProfessorRepository subjectProfessorRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectProfessorConverter converter;

    @Autowired
    private RestTemplate restTemplate;

    public void createSubjectProfessor(SubjectProfessor subjectProfessor) throws SubjectNotFoundException, ProfessorNotFoundException {

        SubjectEntity subjectEntity = subjectRepository.findOne(subjectProfessor.getSubjectId());

        if (subjectEntity == null) {
            throw new SubjectNotFoundException();
        }

        try {
            restTemplate.getForObject("http://localhost:9888/professors/v1/professors/{id}",
                    Professor.class,
                    subjectProfessor.getProfessorId());
        } catch (Exception e) {
            throw new ProfessorNotFoundException();
        }

        subjectProfessorRepository.save(converter.toEntity(subjectProfessor, subjectEntity));
    }

    public SubjectComplete getSubjectWithProfessors(Long id) throws SubjectNotFoundException {
        SubjectEntity subjectEntity = subjectRepository.findById(id);

        if (subjectEntity == null) {
            throw new SubjectNotFoundException();
        }

        List<SubjectProfessor> subjectProfessors =
                subjectProfessorRepository.findBySubjectEntity(subjectEntity).stream()
                        .map(subjectProfessorEntity -> converter.toDto(subjectProfessorEntity)).collect(Collectors.toList());

        List<Professor> professors =
                subjectProfessors.stream().map(subjectProfessor ->
                        restTemplate.getForObject("http://localhost:9888/professors/v1/professors/{id}",
                                Professor.class,
                                subjectProfessor.getProfessorId())
                ).collect(Collectors.toList());


        return SubjectComplete.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .professors(professors)
                .build();
    }

}
