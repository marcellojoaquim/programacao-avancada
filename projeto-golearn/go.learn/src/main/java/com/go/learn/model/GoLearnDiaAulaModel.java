package com.go.learn.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "aula")
public class GoLearnDiaAulaModel {
    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date diaAula;
	

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


    public Date getDiaAula() {
        return diaAula;
    }
    public void setDiaAula(Date diaAula) {
        this.diaAula = diaAula;
}

}