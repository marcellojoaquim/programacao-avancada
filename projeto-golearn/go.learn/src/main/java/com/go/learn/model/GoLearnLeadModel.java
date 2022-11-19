package com.go.learn.model;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "GO_LEARN_LEAD")
public class GoLearnLeadModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 45)
    private String nome;
    @Column(nullable = false, unique = true, length = 20)
    private String telefone;
    @Column(nullable = false)
    private Date datacadastro;
    @Column(nullable = false, unique = true, length = 20)
    private String status_2;
    @Column(nullable = false)
    private Date datanovocontato;
    @Column(nullable = false, unique = true, length = 45)
    private String observacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getStatus_2() {
        return status_2;
    }

    public void setStatus_2(String status_2) {
        this.status_2 = status_2;
    }

    public Date getDatanovocontato() {
        return datanovocontato;
    }

    public void setDatanovocontato(Date datanovocontato) {
        this.datanovocontato = datanovocontato;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
