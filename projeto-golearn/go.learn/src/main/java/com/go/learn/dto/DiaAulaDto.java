package com.go.learn.dto;
import java.util.Date;

public class DiaAulaDto {

    private int curso_IdCurso;
    private Date dataAula;

    public int getCurso_IdCurso() {
        return curso_IdCurso;
    }
    public void setCurso_IdCurso(int curso_IdCurso) {
        this.curso_IdCurso = curso_IdCurso;
    }
    public Date getDataAula() {
        return dataAula;
    }
    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
  }
}