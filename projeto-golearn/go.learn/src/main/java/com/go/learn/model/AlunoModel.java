package com.go.learn.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "alunos")
public class AlunoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaluno;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false, unique = true)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column()
    private String endereco;

    @Column(length = 20)
    private String cpf;
    
    @ManyToOne
    @JoinColumn(name = "turma")
    private TurmaModel turmas;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date registrationDate = new Date();
    
    public Date getRegistrationDate() {
        return registrationDate;
    }
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

    public TurmaModel getTurmas() {
        return turmas;
    }
    public void setTurmas(TurmaModel turmas) {
        this.turmas = turmas;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}