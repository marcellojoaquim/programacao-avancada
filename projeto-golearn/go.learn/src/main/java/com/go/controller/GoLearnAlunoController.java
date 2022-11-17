package com.go.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.dto.GoLearnAlunoDto;
import com.go.service.GoLearnAlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/golearn")
public class GoLearnAlunoController {
    final GoLearnAlunoService goLearnAlunoService;
    public GoLearnAlunoController(GoLearnAlunoService goLearnAlunoService){
        this.goLearnAlunoService = goLearnAlunoService;
    }
    @PostMapping
    public ResponseEntity<Object> saveGolearn(@RequestBody @Validated GoLearnAlunoDto goLearnAlunoDto){
        var GoLearnAlunoModel = new com.go.model.GoLearnAlunoModel();
        BeanUtils.copyProperties(goLearnAlunoDto, GoLearnAlunoModel );
        GoLearnAlunoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(GoLearnAlunoModel.save(goLearnAlunoService));
    }
    
    
}