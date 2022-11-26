package com.go.learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.go.learn.model.GoLearnProfessorModel;
import com.go.learn.repository.GoLearnProfessorRepository;


@Service
public class GoLearnProfessorService {
    
    final GoLearnProfessorRepository professorRepository;

    public GoLearnProfessorService (GoLearnProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public List<GoLearnProfessorModel> findAll(){
        return professorRepository.findAll();
    }

    @Transactional
    public GoLearnProfessorModel save(GoLearnProfessorModel professorModel){
        return professorRepository.save(professorModel);
    }

    public Optional<GoLearnProfessorModel> findById(Long id) {
        return professorRepository.findById(id);
    }

    @Transactional
    public void deletar(GoLearnProfessorModel professorModel) {
		professorRepository.delete(professorModel);
	}

    

}
