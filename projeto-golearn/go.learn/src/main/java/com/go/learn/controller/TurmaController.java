package com.go.learn.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.go.learn.dto.TurmaDto;
import com.go.learn.model.TurmaModel;
import com.go.learn.service.TurmaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/golearn/turma")
public class TurmaController {

    

    final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService =turmaService;
    }

    @GetMapping
    public ResponseEntity<List<TurmaModel>> encontrarTurma() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
    }

    @GetMapping("/{id}")
     public ResponseEntity<Object> encontrarTurmaEspecifica(@PathVariable(value = "id") Long id) {
        Optional<TurmaModel> turmaModelOptional =turmaService.findById(id);
        if (!turmaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada...");
        }
        return ResponseEntity.status(HttpStatus.OK).body(turmaModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> salvarTurma(@RequestBody @Valid TurmaDto turmaDto) {
        if (turmaService.existsBynomeTurma(turmaDto.getNomeTurma())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome já está em uso");
        }
        var turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaDto, turmaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvarTurma(turmaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable(value = "id") Long id){
        Optional<TurmaModel>turmaModelOptional = turmaService.findById(id);
        turmaService.deletarTurma(turmaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso!");
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTurma(@PathVariable(value = "id") Long id,
        @RequestBody @Valid TurmaDto TurmaDto) {
        Optional<TurmaModel> turmaModelOptional = turmaService.findById(id);
        if (!turmaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada...");
        }
        var turmaModel = new TurmaModel();
        BeanUtils.copyProperties(TurmaDto,turmaModel);
        turmaModel.setIdTurma(turmaModelOptional.get().getIdTurma());
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.salvarTurma(turmaModel));
    }

    @GetMapping("/chamadaPdf/{id}")
    public void generatePdf(HttpServletResponse response, @PathVariable(value = "id") Long id) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.turmaService.export(response, id);
    }
}
