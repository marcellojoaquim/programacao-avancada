package com.go.learn.controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.go.learn.service.GoLearnGeradorDePdfService;

import java.io.IOException;

@RestController
@RequestMapping("/golearn/gerador-pdfs")
public class GoLearnGeradorDePdfController {

  @Autowired
  private GoLearnGeradorDePdfService goLearnGeradorDePdfService;

  @GetMapping("{nome}")
  public Document getPdf(@PathVariable String nome) {
     return goLearnGeradorDePdfService.getPdf(nome);
  }

  @GetMapping
  public void getPdfByHtml() throws IOException, DocumentException {
    goLearnGeradorDePdfService.getPdfHtml();
  }
}