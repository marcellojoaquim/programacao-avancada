package com.go.learn.service;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.go.learn.model.TurmaModel;
import com.go.learn.repository.TurmaRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@Service
public class TurmaService {
    
    

    final TurmaRepository turmaRepository;


    final AlunoService alunoService;

    public TurmaService(TurmaRepository turmaRepository,AlunoService alunoService) {
        this.turmaRepository = turmaRepository;
        this.alunoService = alunoService;
    }

    @Transactional
    public TurmaModel salvarTurma(TurmaModel turmaModel) {
        return turmaRepository.save(turmaModel);
    }

    public List<TurmaModel> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<TurmaModel> findById(Long id) {
        return turmaRepository.findById(id);
    }
    
    @Transactional
    public void deletarTurma(TurmaModel goLearnTurmaModel) {
        turmaRepository.delete(goLearnTurmaModel);
    }

    public boolean existsBynomeTurma(String nomeTurma) {
        return turmaRepository.existsBynomeTurma(nomeTurma);
    }

    public void export(HttpServletResponse response, Long idTurma ) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
     
        // Aqui define a fonte do pdf//
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        // Aqui fica o título e a centralização//
        Paragraph paragraph = new Paragraph(turmaRepository.getNomeById(idTurma), fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Aqui já é a mesma coisa de cima, mas diferente kkkkkkkkk//

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        List<String>nomeDosAlunos = alunoService.findNomeByTurmas(idTurma);
            
        Paragraph paragraph2 = new Paragraph(
            nomeDosAlunos.toString().replace("[", " - ").replace("]", "").replace(",", ",\n"),
             fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        Font fontSubTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontSubTitle.setSize(15);
        Paragraph paragraph3 = new Paragraph("ALUNOS :",fontSubTitle);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);    
            

        document.add(paragraph);
        document.add(paragraph3);
        document.add(paragraph2);
        document.close();
    }

}
