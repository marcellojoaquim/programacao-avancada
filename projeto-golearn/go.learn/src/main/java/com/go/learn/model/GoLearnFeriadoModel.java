package com.go.learn.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;


public class GoLearnFeriadoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Date dataferiado;
    @Column(nullable = false)
    private Integer descricao;

    public Date getDataferiado() {
        return dataferiado;
    }

    public void setDataferiado(Date dataferiado) {
        this.dataferiado = dataferiado;
    }

    public Integer getDescricao() {
        return descricao;
    }

    public void setDescricao(Integer descricao) {
        this.descricao = descricao;
    }
}
