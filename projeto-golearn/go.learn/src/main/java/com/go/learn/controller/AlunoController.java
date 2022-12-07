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
import com.go.learn.dto.AlunoDto;
import com.go.learn.model.AlunoModel;
import com.go.learn.model.TurmaModel;
import com.go.learn.service.AlunoService;
import com.go.learn.service.SmsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("/golearn/alunos")
public class AlunoController {
    
    @Autowired
    private SmsService SmsService;

    final AlunoService alunoService;
    
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }
    
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        SmsService.enviarSms(id);
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> encontrarAluno(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarAlunoEspecifico(@PathVariable(value = "id") Long id){
        Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
        if(!alunoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoModelOptional.get());
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateAluno(@PathVariable(value= "id") Long id, @RequestBody @Valid AlunoDto alunoDto){
        Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
        if(!alunoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado...");
        }
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        alunoModel.setIdaluno(alunoModelOptional.get().getIdaluno());
        alunoModel.setTurmas(new TurmaModel(alunoDto.getTurma()));
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(alunoModel));
    }   

    @PostMapping
    public ResponseEntity<Object> salvarAluno(@RequestBody @Valid AlunoDto alunoDto){
         if(alunoService.existsByCpf(alunoDto.getCpf())) {
		 	return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já está em uso");
		 }
        var alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDto, alunoModel);
        if (alunoDto.getTurma() != null) {
            alunoModel.setTurmas(new TurmaModel(alunoDto.getTurma()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoModel));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") Long id){
        Optional<AlunoModel>alunoModelOptional =alunoService.findById(id);
        alunoService.deletar(alunoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
    } 
    
    @PostMapping("/login")
    public ResponseEntity<Object> validarSenha(@Valid @RequestBody AlunoModel alunoModel){
        boolean valid = alunoService.validarSenha(alunoModel);
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