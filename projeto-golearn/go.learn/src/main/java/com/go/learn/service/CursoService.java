package com.go.learn.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.go.learn.model.CursoModel;
import com.go.learn.repository.CursoRepository;

@Service
public class CursoService {

	final CursoRepository cursoRepository;
	
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public List<CursoModel> findAll(){
		return cursoRepository.findAll();
	}
	
	@Transactional
	public CursoModel save(CursoModel goLearnCursoModel) {
		return cursoRepository.save(goLearnCursoModel);
	}

	public Optional<CursoModel> findById(Long id) {
        return cursoRepository.findById(id);
    }
	
	@Transactional
	public void deletar(CursoModel goLearnCursoModel) {
		cursoRepository.delete(goLearnCursoModel);
	}
	
	public boolean cursoExistente(String nomeCurso) {
		return cursoRepository.existsByNomeCurso(nomeCurso);
	}
	
}
