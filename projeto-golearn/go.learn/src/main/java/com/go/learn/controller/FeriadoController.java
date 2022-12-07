package com.go.learn.controller;
import com.go.learn.dto.FeriadoDto;
import com.go.learn.model.FeriadoModel;
import com.go.learn.service.FeriadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/golearn/feriado")
public class FeriadoController {

   final FeriadoService goLearnFeriadoService;

    public FeriadoController(FeriadoService goLearnFeriadoService) {
        this.goLearnFeriadoService = goLearnFeriadoService;
    }

    @GetMapping
    public ResponseEntity<List<FeriadoModel>> acharTodosFeriados() {
        return ResponseEntity.status(HttpStatus.OK).body(goLearnFeriadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontraFeriadoEspecifico(@PathVariable(value = "id") Long id){
        Optional<FeriadoModel> leadOptional = goLearnFeriadoService.findById(id);
        if(!leadOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead não encontrado...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(leadOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarFeriado (@RequestBody @Valid FeriadoDto goLearnFeriadoDto){
        var golearnFeriadoModel = new FeriadoModel();
        BeanUtils.copyProperties(goLearnFeriadoDto, golearnFeriadoModel);;
        return ResponseEntity.status(HttpStatus.CREATED).body(goLearnFeriadoService.save(golearnFeriadoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarFeriado(@PathVariable(value="id") Long id){
        Optional<FeriadoModel> goLearnFeriadoModelOptional = goLearnFeriadoService.findById(id);
        goLearnFeriadoService.deletar(goLearnFeriadoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLead(@PathVariable(value = "id") Long id, @RequestBody @Valid FeriadoDto goLearnFeriadoDto){
        Optional<FeriadoModel> goLearnFeriadoModelOptional= goLearnFeriadoService.findById(id);
        var goLearnFeriadoModel = new FeriadoModel();
        BeanUtils.copyProperties(goLearnFeriadoDto, goLearnFeriadoModel);
        goLearnFeriadoModel.setDataferiado(goLearnFeriadoModelOptional.get().getDataferiado());
        return ResponseEntity.status(HttpStatus.OK).body(goLearnFeriadoService.save(goLearnFeriadoModel));
    }
}
