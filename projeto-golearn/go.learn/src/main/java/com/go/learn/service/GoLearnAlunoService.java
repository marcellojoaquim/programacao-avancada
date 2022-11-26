package com.go.learn.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.repository.GoLearnAlunoRepository;


@Service
public class GoLearnAlunoService {
   
    final GoLearnAlunoRepository goLearnAlunoRepository;

    public GoLearnAlunoService(GoLearnAlunoRepository goLearnAlunoRepository){
        this.goLearnAlunoRepository = goLearnAlunoRepository;
    }

    public List<GoLearnAlunoModel> findAll(){
        return goLearnAlunoRepository.findAll();
    }

    @Transactional
    public GoLearnAlunoModel save(GoLearnAlunoModel goLearnAlunoModel){
        return goLearnAlunoRepository.save(goLearnAlunoModel);
    }
    public Optional<GoLearnAlunoModel> findById(Long id) {
        return goLearnAlunoRepository.findById(id);
    }
    @Transactional
    public void deletar(GoLearnAlunoModel goLearnAlunoModel) {
        goLearnAlunoRepository.delete(goLearnAlunoModel);
    }

    // public boolean existsByCpfAluno(String cpf) {
	//	return goLearnAlunoRepository.existsByCpfAluno(cpf);
	//}
}
