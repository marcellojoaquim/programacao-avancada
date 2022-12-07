package com.go.learn.dto;
import java.util.List;
import com.go.learn.model.AlunoModel;
import com.go.learn.model.CursoModel;
import com.go.learn.model.ProfessorModel;

public class TurmaDto {
    private Long idTurma;
    private String nomeTurma;
    private float valor;
    private List<AlunoModel> Alunos;
    private AlunoModel idAluno;
    private CursoModel idCurso;
    private ProfessorModel idProfessor;
    

    public List<AlunoModel> getAlunos() {
        return Alunos;
    }
    public void setAlunos(List<AlunoModel> alunos) {
        Alunos = alunos;
    }
    public Long getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public AlunoModel getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(AlunoModel idAluno) {
        this.idAluno = idAluno;
    }
    public CursoModel getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(CursoModel idCurso) {
        this.idCurso = idCurso;
    }
    public ProfessorModel getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(ProfessorModel idProfessor) {
        this.idProfessor = idProfessor;
    }
    public String getNomeTurma() {
        return nomeTurma;
    }
    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
