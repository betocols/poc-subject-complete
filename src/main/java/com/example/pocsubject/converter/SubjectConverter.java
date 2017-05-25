package com.example.pocsubject.converter;

import com.example.pocsubject.domain.SubjectEntity;
import com.example.pocsubject.rest.dto.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {

    public Subject toDto(SubjectEntity subjectEntity) {
        return Subject.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .build();
    }

    public SubjectEntity toEntity(Subject subject) {
        return SubjectEntity.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }
}
