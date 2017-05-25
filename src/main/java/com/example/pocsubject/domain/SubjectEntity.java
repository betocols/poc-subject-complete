package com.example.pocsubject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
@Data
@Builder
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 32)
    private String name;

    @OneToMany(mappedBy = "subjectEntity", cascade = CascadeType.ALL)
    private List<SubjectProfessorEntity> subjectProfessor;
}
