package com.go.learn.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.go.learn.model.ProfessorModel;
import com.go.learn.repository.ProfessorRepository;


@Service
public class ProfessorService {
    
    final ProfessorRepository professorRepository;

    public ProfessorService (ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public List<ProfessorModel> findAll(){
        return professorRepository.findAll();
    }

    @Transactional
    public ProfessorModel save(ProfessorModel professorModel){
        return professorRepository.save(professorModel);
    }

    public Optional<ProfessorModel> findById(Long id) {
        return professorRepository.findById(id);
    }

    @Transactional
    public void deletar(ProfessorModel professorModel) {
		professorRepository.delete(professorModel);
	}

    

}
