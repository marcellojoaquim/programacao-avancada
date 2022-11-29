package com.go.learn.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class GoLearnTurmaModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @Column
    private String nomeTurma;

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
 
    @OneToMany
    @JoinColumn(name = "alunos")
    private List<GoLearnAlunoModel> Alunos;

    @ManyToOne
    @JoinColumn
    private GoLearnCursoModel id;

    @ManyToOne
    @JoinColumn
    private GoLearnProfessorModel idProfessor;

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


    public List<GoLearnAlunoModel> getAlunos() {
        return Alunos;
    }

    public void setAlunos(List<GoLearnAlunoModel> alunos) {
        Alunos = alunos;
    }

    public GoLearnCursoModel getId() {
        return id;
    }

    public void setId(GoLearnCursoModel id) {
        this.id = id;
    }

    public GoLearnProfessorModel getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(GoLearnProfessorModel idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    
    
}
