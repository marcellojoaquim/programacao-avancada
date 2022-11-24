package com.go.learn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.go.learn.service.GoLearnAlunoService;



@Entity
@Table(name = "Go_Learn_Aluno")
public class GoLearnAlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false,unique = true, length = 20)
    private String telefone;
    @Column(nullable = false,length = 45)
    private String endereco;
    @Column(nullable = false, unique = true,length = 20)
    private String cpf;
    @Column(nullable = false)
    private Integer turmaId;
    @Column(nullable = true) 
    private LocalDateTime registrationDate;
    
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    public Integer getTurmaId() {
        return turmaId;
    }
    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }
    public Long getIdaluno() {
        return idAluno;
    }
    public void setIdaluno(Long idAluno) {
        this.idAluno = idAluno;
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
    public void setRegistrationDate(LocalDateTime registrationDate) {
      this.registrationDate = registrationDate;
    }
    public Object save(GoLearnAlunoService goLearnAlunoService) {
        return goLearnAlunoService.goLearnAlunoRepository.save(this);
    }

    

}