package com.go.learn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.go.learn.model.TurmaModel;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long>{
    boolean existsBynomeTurma(String nomeTurma); 
    
    @Query("select nomeTurma from TurmaModel where idTurma =:id")
    String getNomeById(@Param("id")Long id);
}


