package com.go.learn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.go.learn.model.GoLearnTurmaModel;
import com.go.learn.repository.GoLearnTurmaRepository;

@Service
public class GoLearnTurmaService {
    
   final GoLearnTurmaRepository turmaRepository;


    public GoLearnTurmaService(GoLearnTurmaRepository turmaRepository) {
    this.turmaRepository = turmaRepository;
}

    @Transactional
	public GoLearnTurmaModel salvarTurma(GoLearnTurmaModel goLearnTurmaModel) {
		return turmaRepository.save(goLearnTurmaModel);
	}

    public List<GoLearnTurmaModel> findAll(){
		return turmaRepository.findAll();
	}

    public Optional<GoLearnTurmaModel> findById(Long id) {
        return turmaRepository.findById(id);
    }
  
    @Transactional
    public void deletarTurma(GoLearnTurmaModel goLearnTurmaModel){
         turmaRepository.delete(goLearnTurmaModel);
    }

    public boolean existsBynomeTurma(String nomeTurma){
        return turmaRepository.existsBynomeTurma(nomeTurma);
    }

}
