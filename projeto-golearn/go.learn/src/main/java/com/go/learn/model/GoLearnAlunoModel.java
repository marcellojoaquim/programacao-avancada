package com.go.learn.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "aluno")
public class GoLearnAlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaluno;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(length = 20)
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name = "turmas")
    private GoLearnTurmaModel turma;

    // @Column(nullable = false, unique = true)
    // private Integer turmaId;
    // @Column(nullable = false) 
    private Date registrationDate = new Date();
    
    public Date getRegistrationDate() {
        return registrationDate;
    }
    // public Integer getTurmaId() {
    //     return turmaId;
    // }
    // public void setTurmaId(Integer turmaId) {
    //     this.turmaId = turmaId;
    // }
    public Long getIdaluno() {
        return idaluno;
    }
    public void setIdaluno(Long idaluno) {
        this.idaluno = idaluno;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setRegistrationDate(Date registrationDate) {
      this.registrationDate = registrationDate;
    }

    public GoLearnTurmaModel getTurma() {
        return turma;
    }
    public void setTurma(GoLearnTurmaModel turma) {
        this.turma = turma;
    }
}