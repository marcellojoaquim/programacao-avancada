package com.go.learn.controller;


// import java.time.ZoneId;

import javax.validation.Valid;
// import javax.websocket.server.PathParam;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.learn.dto.GoLearnAlunoDto;
import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.service.GoLearnAlunoService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/golearn/aluno")
public class GoLearnAlunoController {
    
    final GoLearnAlunoService goLearnAlunoService;
    
    public GoLearnAlunoController(GoLearnAlunoService goLearnAlunoService){
        this.goLearnAlunoService = goLearnAlunoService;
    }
    @GetMapping
    public ResponseEntity<List<GoLearnAlunoModel>> encontrarAluno(){
        return ResponseEntity.status(HttpStatus.OK).body(goLearnAlunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarAlunoEspecifico(@PathVariable(value = "id") Long id){
        Optional<GoLearnAlunoModel> goLearnAlunoModelOptional = goLearnAlunoService.findById(id);
        if(!goLearnAlunoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(goLearnAlunoModelOptional.get());
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateAluno(@PathVariable(value= "id") long id, @RequestBody @Valid GoLearnAlunoDto goLearnAlunoDto){
        Optional<GoLearnAlunoModel> goLearnAlunoModelOptional = goLearnAlunoService.findById(id);
        if(!goLearnAlunoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado...");
        }
        var goLearnAlunoModel = new GoLearnAlunoModel();
        BeanUtils.copyProperties(goLearnAlunoDto, goLearnAlunoModel);
        goLearnAlunoModel.setIdaluno(goLearnAlunoModelOptional.get().getIdaluno());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnAlunoService.save(goLearnAlunoModel));
    }   

    @PostMapping
    public ResponseEntity<Object> salvarAluno(@RequestBody @Valid GoLearnAlunoDto goLearnAlunoDto){
        // if(goLearnAlunoService.alunoExistente(goLearnAlunoDto.getCpf())){
        //     return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já está em uso.");
        // }
        var goLearnAlunoModel = new GoLearnAlunoModel();
        BeanUtils.copyProperties(goLearnAlunoDto, goLearnAlunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnAlunoService.save(goLearnAlunoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") long id){
        Optional<GoLearnAlunoModel> goLearnAlunoModelOptional = goLearnAlunoService.findById(id);
        goLearnAlunoService.deletar(goLearnAlunoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    } 
    
    
}