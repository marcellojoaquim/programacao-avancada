package com.go.learn.service;

import com.go.learn.model.GoLearnLeadModel;
import com.go.learn.repository.GoLearnLeadRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoLearnLeadService {

    public final GoLearnLeadRepository goLearnLeadRepository;


    public GoLearnLeadService(GoLearnLeadRepository goLearnLeadRepository) {
        this.goLearnLeadRepository = goLearnLeadRepository;
    }

    public Optional<GoLearnLeadModel> findById(Long id) {

        return goLearnLeadRepository.findById(id);
    }

    @Transactional
    public Object save(GoLearnLeadModel goLearnLeadModel) {

        return goLearnLeadRepository.save(goLearnLeadModel);
    }
    @Transactional
    public void deletar(GoLearnLeadModel goLearnLeadModel) {
        goLearnLeadRepository.delete(goLearnLeadModel);
    }

    public List<GoLearnLeadModel> findAll() {
        return goLearnLeadRepository.findAll();

    }
}