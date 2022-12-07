package com.go.learn.service;
import com.go.learn.model.LeadModel;
import com.go.learn.repository.LeadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    public final LeadRepository goLearnLeadRepository;


    public LeadService(LeadRepository goLearnLeadRepository) {
        this.goLearnLeadRepository = goLearnLeadRepository;
    }

    public Optional<LeadModel> findById(Long id) {

        return goLearnLeadRepository.findById(id);
    }

    @Transactional
    public Object save(LeadModel goLearnLeadModel) {

        return goLearnLeadRepository.save(goLearnLeadModel);
    }
    @Transactional
    public void deletar(LeadModel goLearnLeadModel) {
        goLearnLeadRepository.delete(goLearnLeadModel);
    }

    public List<LeadModel> findAll() {
        return goLearnLeadRepository.findAll();

    }
}