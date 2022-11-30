package com.go.learn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.model.GoLearnTurmaModel;



@Repository
public interface GoLearnAlunoRepository extends JpaRepository<GoLearnAlunoModel, Long>{

     boolean existsByCpf(String cpf);
     Iterable <GoLearnAlunoModel> findByTurma(Optional<GoLearnTurmaModel> goLearnTurmaModel);
}
