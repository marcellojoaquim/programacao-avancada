package com.go.learn.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.go.learn.model.GoLearnCursoModel;
import com.go.learn.repository.GoLearnCursoRepository;

@Service
public class GoLearnCursoService {

	final GoLearnCursoRepository cursoRepository;
	
	public GoLearnCursoService(GoLearnCursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public List<GoLearnCursoModel> findAll(){
		return cursoRepository.findAll();
	}
	
	@Transactional
	public GoLearnCursoModel save(GoLearnCursoModel goLearnCursoModel) {
		return cursoRepository.save(goLearnCursoModel);
	}

	public Optional<GoLearnCursoModel> findById(Long id) {
        return cursoRepository.findById(id);
    }
	
	@Transactional
	public void deletar(GoLearnCursoModel goLearnCursoModel) {
		cursoRepository.delete(goLearnCursoModel);
	}
	
	public boolean cursoExistente(String nomeCurso) {
		return cursoRepository.existsByNomeCurso(nomeCurso);
	}
	
}
