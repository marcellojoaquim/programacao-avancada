package com.go.learn.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "turmas")
public class TurmaModel implements Serializable{

    private static final long serialVersionUID = 1L;

    public TurmaModel(Long idTurma){
        this.idTurma = idTurma;
    }

    public TurmaModel(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @Column
    private String nomeTurma;

    @Column(precision = 6, scale = 2)
    private float valor;
 
    @OneToMany(mappedBy = "turmas", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlunoModel> Alunos;

    @ManyToOne
    @JoinColumn
    private CursoModel id; 

    @ManyToOne
    @JoinColumn
    private ProfessorModel idProfessor;

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
    
    public List<AlunoModel> getAlunos() {
        return Alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        Alunos = alunos;
    }

    public CursoModel getId() {
        return id;
    }

    public void setId(CursoModel id) {
        this.id = id;
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
