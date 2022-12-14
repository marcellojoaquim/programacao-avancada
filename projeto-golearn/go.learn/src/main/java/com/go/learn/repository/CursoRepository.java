package com.go.learn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.go.learn.model.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

	boolean existsByNomeCurso(String nomeCurso);
}
