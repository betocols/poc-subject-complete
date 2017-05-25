package com.example.pocsubject.repository;

import com.example.pocsubject.domain.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    SubjectEntity findById(@Param("id") Long id);

    List<SubjectEntity> findByIdIn(@Param("ids") List<Long> ids);
}
