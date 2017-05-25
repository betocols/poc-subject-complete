package com.example.pocsubject.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectProfessor {

    private Long id;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long professorId;
}
