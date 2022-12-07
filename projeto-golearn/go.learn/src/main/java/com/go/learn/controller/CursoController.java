package com.go.learn.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.go.learn.dto.CursoDto;
import com.go.learn.model.CursoModel;

import com.go.learn.service.CursoService;

@RestController
@RequestMapping(value = "/golearn/cursos")
public class CursoController {

	
	final CursoService goLearnCursoService;
	
	public CursoController(CursoService goLearnCursoService) {
		this.goLearnCursoService = goLearnCursoService;
	}
	
	@GetMapping()
	public ResponseEntity<List<CursoModel>> encontrarCurso() {
		return ResponseEntity.status(HttpStatus.OK).body(goLearnCursoService.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> encontrarEspecifico(@PathVariable(value = "id") Long id){
		Optional<CursoModel> goLearnCursoModelOptional = goLearnCursoService.findById(id);
		if(!goLearnCursoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(goLearnCursoModelOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> salvarCurso(@RequestBody @Valid CursoDto goLearnCursoDto){
		if(goLearnCursoService.cursoExistente(goLearnCursoDto.getNomeCurso())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome já está em uso");
		}
		var goLearnCursoModel = new CursoModel();
		BeanUtils.copyProperties(goLearnCursoDto, goLearnCursoModel);;
		return ResponseEntity.status(HttpStatus.CREATED).body(goLearnCursoService.save(goLearnCursoModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarCurso(@PathVariable(value="id") Long id){
		Optional<CursoModel> goLearnCursoModelOptional = goLearnCursoService.findById(id);
		goLearnCursoService.deletar(goLearnCursoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCurso(@PathVariable(value = "id") Long id, @RequestBody @Valid CursoDto goLearnCursoDto){
		Optional<CursoModel> goLearnCursoModelOptional = goLearnCursoService.findById(id);
		if(!goLearnCursoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado...");
		}
		var goLearnCursoModel = new CursoModel();
		BeanUtils.copyProperties(goLearnCursoDto, goLearnCursoModel);
		goLearnCursoModel.setId(goLearnCursoModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(goLearnCursoService.save(goLearnCursoModel));	
	}
	
}
