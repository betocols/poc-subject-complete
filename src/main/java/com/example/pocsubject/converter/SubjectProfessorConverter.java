package com.example.pocsubject.converter;

import com.example.pocsubject.domain.SubjectEntity;
import com.example.pocsubject.domain.SubjectProfessorEntity;
import com.example.pocsubject.rest.dto.SubjectProfessor;
import org.springframework.stereotype.Component;

@Component
public class SubjectProfessorConverter {


    public SubjectProfessorEntity toEntity(SubjectProfessor subjectProfessor, SubjectEntity subjectEntity) {
        return SubjectProfessorEntity.builder()
                .professorId(subjectProfessor.getProfessorId())
                .subjectEntity(subjectEntity)
                .build();
    }

    public SubjectProfessor toDto(SubjectProfessorEntity subjectProfessorEntity) {
        return SubjectProfessor.builder()
                .id(subjectProfessorEntity.getId())
                .professorId(subjectProfessorEntity.getProfessorId())
                .subjectId(subjectProfessorEntity.getSubjectEntity().getId())
                .build();
    }
}
