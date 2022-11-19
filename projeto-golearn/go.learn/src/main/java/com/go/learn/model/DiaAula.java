package com.go.learn.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name = "Dia_Aula")
public class DiaAula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID diaAula;
    
    public UUID getDiaAula() {
        return diaAula;
    }
    public void setDiaAula(UUID diaAula) {
        this.diaAula = diaAula;
    }
    @Column(nullable = false)
    private int curso_IdCurso;

    @Column(nullable = false)
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