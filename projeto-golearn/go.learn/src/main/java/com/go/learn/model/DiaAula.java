package com.go.learn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


@Entity
 public class DiaAula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int curso_IdCurso;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dataAula;
    
    public int getCurso_IdCurso() {
        return curso_IdCurso;
    }
    public void setCurso_IdCurso(int curso_IdCurso) {
        this.curso_IdCurso = curso_IdCurso;
    }
    public int getDataAula() {
        return dataAula;
    }
    public void setDataAula(int dataAula) {
        this.dataAula = dataAula;
    }
}    