package com.go.learn.controller;
import com.go.learn.dto.LeadDto;
import com.go.learn.model.LeadModel;
import com.go.learn.service.LeadService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("golearn/lead")
public class LeadController {

    final LeadService goLearnLeadService;


    public LeadController(LeadService goLearnLeadService) {
        this.goLearnLeadService = goLearnLeadService;

    }
    @GetMapping
    public ResponseEntity<List<LeadModel>> acharTodosOsLeads() {
        return ResponseEntity.status(HttpStatus.OK).body(goLearnLeadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontraLeadEspecifico(@PathVariable(value = "id") Long id){
        Optional<LeadModel> leadOptional = goLearnLeadService.findById(id);
        if(!leadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(leadOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarLead (@RequestBody @Valid LeadDto goLearnLeadDto){

        var goLearnLeadModel = new LeadModel();
        BeanUtils.copyProperties(goLearnLeadDto, goLearnLeadModel);;
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnLeadService.save(goLearnLeadModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarLead(@PathVariable(value="id") Long id){
        Optional<LeadModel> goLearnLeadModelOptional = goLearnLeadService.findById(id);
        goLearnLeadService.deletar(goLearnLeadModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLead(@PathVariable(value = "id") Long id, @RequestBody @Valid LeadDto goLearnLeadDto){
        Optional<LeadModel>  goLearnLeadModelOptional= goLearnLeadService.findById(id);

        var goLearnLeadModel = new LeadModel();
        BeanUtils.copyProperties(goLearnLeadDto, goLearnLeadModel);
        goLearnLeadModel.setIdLead(goLearnLeadModelOptional.get().getIdLead());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnLeadService.save(goLearnLeadModel));
    }

}
