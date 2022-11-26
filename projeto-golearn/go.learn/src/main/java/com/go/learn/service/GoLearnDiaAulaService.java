package com.go.learn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.go.learn.model.GoLearnDiaAulaModel;
import com.go.learn.repository.GoLearnDiaAulaRepository;


@Service
public class GoLearnDiaAulaService {
    public final GoLearnDiaAulaRepository goLearnDiaAulaRepository;

    public GoLearnDiaAulaService(GoLearnDiaAulaRepository goLearnDiaAulaRepository){
        this.goLearnDiaAulaRepository = goLearnDiaAulaRepository;

    }
    public List<GoLearnDiaAulaModel> findAll(){
		return goLearnDiaAulaRepository.findAll();
	}
	
	@Transactional
	public GoLearnDiaAulaModel save(GoLearnDiaAulaModel goLearnDiaAulaModel) {
		return goLearnDiaAulaRepository.save(goLearnDiaAulaModel);
	}

	public Optional<GoLearnDiaAulaModel> findById(Long id) {
        return goLearnDiaAulaRepository.findById(id);
    }
	
	@Transactional
	public void deletar(GoLearnDiaAulaModel goLearnDiaAulaModel) {
		goLearnDiaAulaRepository.delete(goLearnDiaAulaModel);
	}
	
	

}