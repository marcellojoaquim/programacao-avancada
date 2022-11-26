package com.go.learn.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.learn.dto.GoLearnProfessorDto;
import com.go.learn.model.GoLearnProfessorModel;
import com.go.learn.service.GoLearnProfessorService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;



@RestController
@RequestMapping(value = "/golearn/professor")
public class GoLearnProfessorController {
    
    final GoLearnProfessorService professorservice;

    public GoLearnProfessorController (GoLearnProfessorService professorService){
        this.professorservice = professorService;
    }

    @GetMapping
    public ResponseEntity<List<GoLearnProfessorModel>> encontrarCurso() {
		return ResponseEntity.status(HttpStatus.OK).body(professorservice.findAll()); 
	}

    @GetMapping("/{id}")
	public ResponseEntity<Object> encontrarEspecifico(@PathVariable(value = "id") Long id){
		Optional<GoLearnProfessorModel> professorModelOptional = professorservice.findById(id);
		if(!professorModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(professorModelOptional.get());
	}

    @PostMapping
	public ResponseEntity<Object> salvarProfessor (@RequestBody @Valid GoLearnProfessorDto goLearnCursoDto){
		
		var goLearnCursoModel = new GoLearnProfessorModel();
		BeanUtils.copyProperties(goLearnCursoDto, goLearnCursoModel);;
		return ResponseEntity.status(HttpStatus.CREATED).body(professorservice.save(goLearnCursoModel));
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarCurso(@PathVariable(value="id") Long id){
		Optional<GoLearnProfessorModel> goLearnCursoModelOptional = professorservice.findById(id);
		professorservice.deletar(goLearnCursoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
	}

    @PutMapping("/{id}")
	public ResponseEntity<Object> updateCurso(@PathVariable(value = "id") Long id, @RequestBody @Valid GoLearnProfessorDto goLearnProfessorDto){
		Optional<GoLearnProfessorModel> goLearnCursoModelOptional = professorservice.findById(id);
		
		var goLearnCursoModel = new GoLearnProfessorModel();
		BeanUtils.copyProperties(goLearnProfessorDto, goLearnCursoModel);
		goLearnCursoModel.setId(goLearnCursoModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(professorservice.save(goLearnCursoModel));
	}

}
