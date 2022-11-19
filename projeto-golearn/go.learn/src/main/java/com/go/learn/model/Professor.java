package com.go.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    
    @Column(nullable = false)
    private String nome;

    @Column
    private int telefone;

    @Column(nullable = false)
    private float valorHoraAula;

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public float getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(float valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
    
}
