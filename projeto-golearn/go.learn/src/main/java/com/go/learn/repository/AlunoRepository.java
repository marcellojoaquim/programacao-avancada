package com.go.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.go.learn.model.AlunoModel;




@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long>{

      boolean existsByCpf(String cpf);
     // Iterable <GoLearnAlunoModel> findByTurma(Optional<GoLearnTurmaModel> goLearnTurmaModel);

     // @Query(nativeQuery = true, value = "select nome from aluno")
     // List<AlunosMinProjections>findByTurma(String turma);
      @Query("Select nome from AlunoModel where turmas.idTurma = :turma")
      List<String>findNomeByTurma(@Param("turma")Long turma);
}
