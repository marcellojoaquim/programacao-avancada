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
import com.go.learn.dto.GoLearnDiaAulaDto;
import com.go.learn.model.GoLearnDiaAulaModel;
import com.go.learn.service.GoLearnDiaAulaService;

@RestController
@RequestMapping(value = "/golearn/diaaula")
public class GoLearnDiaAulaController {

	
	final GoLearnDiaAulaService goLearnDiaAulaService;
	
	public GoLearnDiaAulaController(GoLearnDiaAulaService goLearnDiaAulaService) {
		this.goLearnDiaAulaService = goLearnDiaAulaService;
	}
	
	@GetMapping
	public ResponseEntity<List<GoLearnDiaAulaModel>> encontrarAula() {
		return ResponseEntity.status(HttpStatus.OK).body(goLearnDiaAulaService.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> encontrarEspecifico(@PathVariable(value = "id") Long id){
		Optional<GoLearnDiaAulaModel> goLearnDiaAulaModelOptional = goLearnDiaAulaService.findById(id);
		if(!goLearnDiaAulaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula não encontrado...");
		}
		return ResponseEntity.status(HttpStatus.OK).body(goLearnDiaAulaModelOptional.get());
	}

    @PostMapping
	public ResponseEntity<Object> salvarAula (@RequestBody @Valid GoLearnDiaAulaDto goLearnDiaAulaDto){
		
		var goLearnDiaAulaModel = new GoLearnDiaAulaModel();
		BeanUtils.copyProperties(goLearnDiaAulaDto, goLearnDiaAulaModel);;
		return ResponseEntity.status(HttpStatus.CREATED).body(goLearnDiaAulaService.save(goLearnDiaAulaModel));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarAula(@PathVariable(value="id") Long id){
		Optional<GoLearnDiaAulaModel> goLearnDiaAulaModelOptional = goLearnDiaAulaService.findById(id);
		goLearnDiaAulaService.deletar(goLearnDiaAulaModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Aula deletada com sucesso !");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAula(@PathVariable(value = "id") Long id, @RequestBody @Valid GoLearnDiaAulaDto goLearnDiaAulaDto){
		Optional<GoLearnDiaAulaModel> goLearnDiaAulaModelOptional = goLearnDiaAulaService.findById(id);
		if(!goLearnDiaAulaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula não encontrada...");
		}
		var goLearnDiaAulaModel = new GoLearnDiaAulaModel();
		BeanUtils.copyProperties(goLearnDiaAulaDto, goLearnDiaAulaModel);
		goLearnDiaAulaModel.setDiaAula(goLearnDiaAulaModelOptional.get().getDiaAula());
		return ResponseEntity.status(HttpStatus.OK).body(goLearnDiaAulaService.save(goLearnDiaAulaModel));	
	}
	
}
