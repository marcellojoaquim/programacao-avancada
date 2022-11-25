package com.go.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.go.learn.model.GoLearnProfessorModel;

@Repository
<<<<<<< Updated upstream:projeto-golearn/go.learn/src/main/java/com/go/learn/repository/GoLearnProfessorRepository.java
public interface GoLearnProfessorRepository extends JpaRepository<GoLearnProfessorModel, Long> {}
=======
public interface ProfessorRepository extends JpaRepository<Professor, Long> {


    
}
>>>>>>> Stashed changes:projeto-golearn/go.learn/src/main/java/com/go/learn/repository/ProfessorRepository.java
