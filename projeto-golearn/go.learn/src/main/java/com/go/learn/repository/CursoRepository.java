package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnCursoModel;

@Repository
public interface CursoRepository extends JpaRepository<GoLearnCursoModel, Integer> {

}
