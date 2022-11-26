package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnProfessorModel;

@Repository
public interface GoLearnProfessorRepository extends JpaRepository<GoLearnProfessorModel, Long> {}
