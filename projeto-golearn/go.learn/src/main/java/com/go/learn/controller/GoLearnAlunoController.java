package com.go.learn.controller;

import javax.validation.Valid;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.go.learn.dto.GoLearnAlunoDto;
import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.service.GoLearnAlunoService;
import com.go.learn.service.GoLearnSmsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class GoLearnAlunoController {
    
    @Autowired
    private GoLearnSmsService goLearnSmsService;

    final GoLearnAlunoService goLearnAlunoService;
    
    public GoLearnAlunoController(GoLearnAlunoService goLearnAlunoService){
        this.goLearnAlunoService = goLearnAlunoService;
    }
    
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        goLearnSmsService.enviarSms(id);
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
    public ResponseEntity<Object>updateAluno(@PathVariable(value= "id") Long id, @RequestBody @Valid GoLearnAlunoDto goLearnAlunoDto){
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
        // if(goLearnAlunoService.existsByCpf(goLearnAlunoDto.getCpf())) {
		// 	return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já está em uso");
		// }
        var goLearnAlunoModel = new GoLearnAlunoModel();
        BeanUtils.copyProperties(goLearnAlunoDto, goLearnAlunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnAlunoService.save(goLearnAlunoModel));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") Long id){
        Optional<GoLearnAlunoModel> goLearnAlunoModelOptional = goLearnAlunoService.findById(id);
        goLearnAlunoService.deletar(goLearnAlunoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
    } 
    
    @PostMapping("/login")
    public ResponseEntity<Object> validarSenha(@Valid @RequestBody GoLearnAlunoModel goLearnAlunoModel){
        boolean valid = goLearnAlunoService.validarSenha(goLearnAlunoModel);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Login realizado");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}