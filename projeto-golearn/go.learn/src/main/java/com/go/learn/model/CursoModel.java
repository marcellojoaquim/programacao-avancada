package com.go.learn.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class CursoModel implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Verificar se o length funciona para o tipo int
	@Column(length = 25)
	private String nomeCurso;
	
	@Column
	private Float chaula;
	
	@Column
	private Float chtotal;
	
	@Column(length = 25)
	private String turno;
	
	@Column
	private Float valor;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Float getChaula() {
		return chaula;
	}

	public void setChaula(Float chaula) {
		this.chaula = chaula;
	}

	public Float getChtotal() {
		return chtotal;
	}

	public void setChtotal(Float chtotal) {
		this.chtotal = chtotal;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
