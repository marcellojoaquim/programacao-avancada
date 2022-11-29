package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.go.learn.model.GoLearnTurmaModel;

@Repository
public interface GoLearnTurmaRepository extends JpaRepository<GoLearnTurmaModel, Long>{
    boolean existsBynomeTurma(String nomeTurma); 

}
