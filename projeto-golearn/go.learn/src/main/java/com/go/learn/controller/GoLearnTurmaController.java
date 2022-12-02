package com.go.learn.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.go.learn.dto.GoLearnTurmaDto;
import com.go.learn.model.GoLearnTurmaModel;
import com.go.learn.service.GoLearnTurmaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/golearn/turma")
public class GoLearnTurmaController {
    

    final GoLearnTurmaService goLearnTurmaService;

    public GoLearnTurmaController(GoLearnTurmaService goLearnTurmaService) {
        this.goLearnTurmaService = goLearnTurmaService;
    }


    @GetMapping
    public ResponseEntity<List<GoLearnTurmaModel>> encontrarTurma(){
        return ResponseEntity.status(HttpStatus.OK).body(goLearnTurmaService.findAll());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarTurmaEspecifica(@PathVariable(value = "id") Long id){
        Optional<GoLearnTurmaModel> goLearnTurmaModelOptional = goLearnTurmaService.findById(id);
        if(!goLearnTurmaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada...");
		}
        return ResponseEntity.status(HttpStatus.OK).body(goLearnTurmaModelOptional.get());
    } 

    @PostMapping
    public ResponseEntity<Object>salvarTurma(@RequestBody @Valid GoLearnTurmaDto goLearnTurmaDto){
        if(goLearnTurmaService.existsBynomeTurma(goLearnTurmaDto.getNomeTurma())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome já está em uso");
		}
        var goLearnTurmaModel = new GoLearnTurmaModel();
		BeanUtils.copyProperties(goLearnTurmaDto, goLearnTurmaModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(goLearnTurmaService.salvarTurma(goLearnTurmaModel));
    }

    @DeleteMapping
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") long id){
        Optional<GoLearnTurmaModel> goLearnTurmaModelOptional = goLearnTurmaService.findById(id);
        goLearnTurmaService.deletarTurma(goLearnTurmaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso!");
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateAluno(@PathVariable(value= "id") long id, @RequestBody @Valid GoLearnTurmaDto goLearnTurmaDto){
        Optional<GoLearnTurmaModel> goLearnTurmaModelOptional = goLearnTurmaService.findById(id);
        if(!goLearnTurmaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada...");
        }
        var goLearnTurmaModel = new GoLearnTurmaModel();
        BeanUtils.copyProperties(goLearnTurmaDto, goLearnTurmaModel);
        goLearnTurmaModel.setIdTurma(goLearnTurmaModelOptional.get().getIdTurma());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnTurmaService.salvarTurma(goLearnTurmaModel));
    }   
}
