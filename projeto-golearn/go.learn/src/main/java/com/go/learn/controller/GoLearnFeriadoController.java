package com.go.learn.controller;


import com.go.learn.dto.GoLearnFeriadoDto;
import com.go.learn.model.GoLearnFeriadoModel;
import com.go.learn.service.GoLearnFeriadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/golearn/feriado")
public class GoLearnFeriadoController {

   final GoLearnFeriadoService goLearnFeriadoService;

    public GoLearnFeriadoController(GoLearnFeriadoService goLearnFeriadoService) {
        this.goLearnFeriadoService = goLearnFeriadoService;
    }

    @GetMapping
    public ResponseEntity<List<GoLearnFeriadoModel>> acharTodosFeriados() {
        return ResponseEntity.status(HttpStatus.OK).body(goLearnFeriadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontraFeriadoEspecifico(@PathVariable(value = "id") Long id){
        Optional<GoLearnFeriadoModel> leadOptional = goLearnFeriadoService.findById(id);
        if(!leadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(leadOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarFeriado (@RequestBody @Valid GoLearnFeriadoDto goLearnFeriadoDto){
        var golearnFeriadoModel = new GoLearnFeriadoModel();
        BeanUtils.copyProperties(goLearnFeriadoDto, golearnFeriadoModel);;
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnFeriadoService.save(golearnFeriadoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarFeriado(@PathVariable(value="id") Long id){
        Optional<GoLearnFeriadoModel> goLearnFeriadoModelOptional = goLearnFeriadoService.findById(id);
        goLearnFeriadoService.deletar(goLearnFeriadoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLead(@PathVariable(value = "id") Long id, @RequestBody @Valid GoLearnFeriadoDto goLearnFeriadoDto){
        Optional<GoLearnFeriadoModel> goLearnFeriadoModelOptional= goLearnFeriadoService.findById(id);
        var goLearnFeriadoModel = new GoLearnFeriadoModel();
        BeanUtils.copyProperties(goLearnFeriadoDto, goLearnFeriadoModel);
        goLearnFeriadoModel.setDataferiado(goLearnFeriadoModelOptional.get().getDataferiado());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnFeriadoService.save(goLearnFeriadoModel));
    }
}
