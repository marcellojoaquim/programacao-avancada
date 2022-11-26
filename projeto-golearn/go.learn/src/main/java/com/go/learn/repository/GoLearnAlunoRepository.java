package com.go.learn.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnAlunoModel;



@Repository
public interface GoLearnAlunoRepository extends JpaRepository <GoLearnAlunoModel,Long>{
    List<GoLearnAlunoModel> findByCpf(String cpf);
    // boolean existsByCpfAluno(String cpf);
}
