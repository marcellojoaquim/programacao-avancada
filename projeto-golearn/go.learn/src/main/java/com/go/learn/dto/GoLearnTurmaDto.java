package com.go.learn.dto;

import com.go.learn.model.GoLearnAlunoModel;
import com.go.learn.model.GoLearnCursoModel;
import com.go.learn.model.Professor;

public class GoLearnTurmaDto {
    private Long idTurma;
    private float valor;
    private GoLearnAlunoModel idAluno;
    private GoLearnCursoModel idCurso;
    private Professor idProfessor;
    private Integer seg;
    private Integer ter;
    private Integer qua;
    private Integer qui;
    private Integer sab;

    public Integer getSeg() {
        return seg;
    }
    public void setSeg(Integer seg) {
        this.seg = seg;
    }
    public Integer getTer() {
        return ter;
    }
    public void setTer(Integer ter) {
        this.ter = ter;
    }
    public Integer getQua() {
        return qua;
    }
    public void setQua(Integer qua) {
        this.qua = qua;
    }
    public Integer getQui() {
        return qui;
    }
    public void setQui(Integer qui) {
        this.qui = qui;
    }
    public Integer getSab() {
        return sab;
    }
    public void setSab(Integer sab) {
        this.sab = sab;
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
    public GoLearnAlunoModel getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(GoLearnAlunoModel idAluno) {
        this.idAluno = idAluno;
    }
    public GoLearnCursoModel getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(GoLearnCursoModel idCurso) {
        this.idCurso = idCurso;
    }
    public Professor getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }
    
}
