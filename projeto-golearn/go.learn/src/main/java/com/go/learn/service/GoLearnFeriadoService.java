package com.go.learn.service;

import com.go.learn.model.GoLearnFeriadoModel;
import com.go.learn.repository.GoLearnFeriadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GoLearnFeriadoService {

    public final GoLearnFeriadoRepository goLearnFeriadoRepository;

    public GoLearnFeriadoService(GoLearnFeriadoRepository goLearnFeriadoRepository) {
        this.goLearnFeriadoRepository = goLearnFeriadoRepository;
    }


    public Optional<GoLearnFeriadoModel> findById(Long id) {

        return goLearnFeriadoRepository.findById(id);
    }

    @Transactional
    public Object save(GoLearnFeriadoModel goLearnFeriadoModel) {

        return goLearnFeriadoRepository.save(goLearnFeriadoModel);
    }
    @Transactional
    public void deletar(GoLearnFeriadoModel goLearnFeriadoModel) {
        goLearnFeriadoRepository.delete(goLearnFeriadoModel);
    }

    public List<GoLearnFeriadoModel> findAll() {
        return goLearnFeriadoRepository.findAll();

    }

}
