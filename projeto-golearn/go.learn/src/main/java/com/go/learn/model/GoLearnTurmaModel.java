package com.go.learn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Turma")
public class GoLearnTurmaModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @Column(precision = 6, scale = 2)
    private float valor;

    @Column
    private Integer seg;

    @Column
    private Integer ter;

    @Column
    private Integer qua;

    @Column
    private Integer qui;

    @Column
    private Integer sex;

    @Column
    private Integer sab;
 
    @ManyToOne
    @JoinColumn(nullable = false)
    private GoLearnAlunoModel idAluno;

    @ManyToOne
    @JoinColumn(nullable = false)
    private GoLearnCursoModel idCurso;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Professor idProfessor;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSab() {
        return sab;
    }

    public void setSab(Integer sab) {
        this.sab = sab;
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
