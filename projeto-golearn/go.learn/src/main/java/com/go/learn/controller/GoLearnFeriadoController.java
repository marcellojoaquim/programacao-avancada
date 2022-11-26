package com.go.learn.controller;


import com.go.learn.service.GoLearnFeriadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/golearn/feriado")
public class GoLearnFeriadoController {

   final GoLearnFeriadoService goLearnFeriadoService;

    public GoLearnFeriadoController(GoLearnFeriadoService goLearnFeriadoService) {
        this.goLearnFeriadoService = goLearnFeriadoService;
    }
}
