package com.example.pocsubject.repository;

import com.example.pocsubject.domain.SubjectEntity;
import com.example.pocsubject.domain.SubjectProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectProfessorRepository extends JpaRepository<SubjectProfessorEntity, Long> {
    List<SubjectProfessorEntity> findBySubjectEntity(@Param("subject") SubjectEntity subjectEntity);

}
