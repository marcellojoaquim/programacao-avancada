package com.go.learn.controller;


import com.go.learn.dto.GoLearnLeadDto;
import com.go.learn.model.GoLearnLeadModel;
import com.go.learn.service.GoLearnLeadService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("golearn/lead")
public class GoLeranLeadController {

    final GoLearnLeadService goLearnLeadService;


    public GoLeranLeadController(GoLearnLeadService goLearnLeadService) {
        this.goLearnLeadService = goLearnLeadService;

    }
    @GetMapping
    public ResponseEntity<List<GoLearnLeadModel>> acharTodosOsLeads() {
        return ResponseEntity.status(HttpStatus.OK).body(goLearnLeadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontraLeadEspecifico(@PathVariable(value = "id") Long id){
        Optional<GoLearnLeadModel> leadOptional = goLearnLeadService.findById(id);
        if(!leadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(leadOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarLead (@RequestBody @Valid GoLearnLeadDto goLearnLeadDto){

        var goLearnLeadModel = new GoLearnLeadModel();
        BeanUtils.copyProperties(goLearnLeadDto, goLearnLeadModel);;
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnLeadService.save(goLearnLeadModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarLead(@PathVariable(value="id") Long id){
        Optional<GoLearnLeadModel> goLearnLeadModelOptional = goLearnLeadService.findById(id);
        goLearnLeadService.deletar(goLearnLeadModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLead(@PathVariable(value = "id") Long id, @RequestBody @Valid GoLearnLeadDto goLearnLeadDto){
        Optional<GoLearnLeadModel>  goLearnLeadModelOptional= goLearnLeadService.findById(id);

        var goLearnLeadModel = new GoLearnLeadModel();
        BeanUtils.copyProperties(goLearnLeadDto, goLearnLeadModel);
        goLearnLeadModel.setIdLead(goLearnLeadModelOptional.get().getIdLead());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnLeadService.save(goLearnLeadModel));
    }

}
