package com.go.learn.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.learn.repository.GoLearnAlunoRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.MultiColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class GoLearnGeradorDePdfService {

  @Autowired
  private GoLearnAlunoRepository goLearnAlunoRepository;

  public Document getPdf(String nome) {
    Aluno aluno = GoLearnAlunoRepository.findByNome(nome);
    Document document = new Document();

      try {

        PdfWriter.getInstance(document, new FileOutputStream("/home/surfista/Downloads/demo/src/pdf" + pessoa.getNome() +".pdf"));
        document.open();
        document.setPageSize(PageSize.A3);

        document.addHeader(pessoa.getNome(), "Contrato de Compra");
        document.addAuthor("Marcelo Thomé");
        document.addCreationDate();
        document.add(new Paragraph("Contrato de Venda - " + pessoa.getNome()));
        document.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod elementum nisi quis eleifend" +
                " quam adipiscing vitae proin sagittis. Pellentesque adipiscing commodo elit at imperdiet. Quis enim lobortis scelerisque fermentum dui faucibus. Leo duis ut diam quam nulla porttitor massa id. Augue neque gravida in fermentum et sollicitudin ac orci phasellus. Placerat in egestas erat imperdiet sed euismod nisi porta. Ut placerat orci nulla pellentesque dignissim enim. Ornare lectus sit amet est placerat in. Enim eu turpis egestas pretium aenean pharetra. Vestibulum sed arcu non odio euismod lacinia. Nunc faucibus a pellentesque sit. Fermentum iaculis eu non diam phasellus vestibulum.\n" +
                "\n" +
                "Fames ac turpis egestas sed tempus urna. Arcu ac tortor dignissim convallis aenean et. " +
                "Est ultricies integer quis auctor elit. Cursus vitae congue mauris rhoncus aenean vel elit" +
                " scelerisque. Sit amet consectetur adipiscing elit duis tristique sollicitudin nibh. Maecenas ultricies mi eget mauris pharetra. Ornare suspendisse sed nisi lacus. Tincidunt tortor aliquam nulla facilisi cras fermentum odio. Pharetra pharetra massa massa ultricies mi quis hendrerit. Purus ut faucibus pulvinar elementum integer enim. Diam sollicitudin tempor id eu nisl nunc mi ipsum. Porta nibh venenatis cras sed felis eget velit. Justo donec enim diam vulputate. Volutpat diam ut venenatis tellus in metus. Turpis egestas integer eget aliquet nibh praesent tristique magna. Vitae congue mauris rhoncus aenean. Vitae suscipit tellus mauris a diam maecenas. Semper viverra nam libero justo laoreet sit amet cursus sit. Eget aliquet nibh praesent tristique magna sit amet purus gravida.\n" +
                "\n" +
                "Facilisi nullam vehicula ipsum a arcu cursus vitae. Magna fringilla urna porttitor rhoncus dolor." +
                " Quam elementum pulvinar etiam non. Eleifend quam adipiscing vitae proin sagittis. Arcu risus quis varius quam quisque id diam vel. Maecenas volutpat blandit aliquam etiam erat velit. Porttitor rhoncus dolor purus non. Rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat. Enim sed faucibus turpis in eu mi bibendum neque egestas. A lacus vestibulum sed arcu non odio euismod. Interdum varius sit amet mattis vulputate enim nulla aliquet porttitor. Ipsum suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Tortor dignissim convallis aenean et tortor at risus. Varius duis at consectetur lorem donec massa. Sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula ipsum. Maecenas ultricies mi eget mauris pharetra et ultrices neque. Consequat nisl vel pretium lectus quam id. Amet risus nullam eget felis eget nunc. Mattis pellentesque id nibh tortor id aliquet lectus. Orci porta non pulvinar neque laoreet suspendisse interdum consectetur."));
        document.add(new PdfPTable(3));
        document.add(new List(1));
        document.add(new MultiColumnText(200,500));
      }
      catch(DocumentException de) {
        System.err.println(de.getMessage());
      }
      catch(IOException ioe) {
        System.err.println(ioe.getMessage());
      }
      document.close();

    return document;
  }

  public void getPdfHtml() throws IOException, DocumentException {
    OutputStream os = new FileOutputStream("/home/surfista/Downloads/demo/src/hello.pdf");;
    Html2Pdf.convert("<h1 style=\"font-family: Roboto, Helvetica, sans-serif;\">Contrato de Venda</h1>" +
                           "<p style=\"font-family:Roboto\">  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Euismod elementum nisi quis eleifend\" +\n" +
            "                \" quam adipiscing vitae proin sagittis. Pellentesque adipiscing commodo elit at imperdiet. Quis enim lobortis scelerisque fermentum dui faucibus. Leo duis ut diam quam nulla porttitor massa id. Augue neque gravida in fermentum et sollicitudin ac orci phasellus. Placerat in egestas erat imperdiet sed euismod nisi porta. Ut placerat orci nulla pellentesque dignissim enim. Ornare lectus sit amet est placerat in. Enim eu turpis egestas pretium aenean pharetra. Vestibulum sed arcu non odio euismod lacinia. Nunc faucibus a pellentesque sit. Fermentum iaculis eu non diam phasellus vestibulum.</p>" , os);
    os.close();
  }
}