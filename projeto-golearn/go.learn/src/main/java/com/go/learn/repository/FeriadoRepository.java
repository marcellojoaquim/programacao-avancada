package com.go.learn.repository;
import com.go.learn.model.FeriadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriadoRepository extends JpaRepository<FeriadoModel, Long> {
}
