package com.go.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Curso")
public class GoLearnCursoModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// Verificar se o length funciona para o tipo int
	@Column(nullable = false, length = 25)
	private String nomeCurso;
	
	@Column(nullable = false)
	private Float chaula;
	
	@Column(nullable = false)
	private Float chtotal;
	
	@Column(nullable = false, length = 25)
	private String turno;
	
	@Column(nullable = false)
	private Float valor;
	
	@Column(nullable = false)
	private Integer seg;
	
	@Column(nullable = false)
	private Integer ter;
	
	@Column(nullable = false)
	private Integer qua;
	
	@Column(nullable = false)
	private Integer qui;
	
	@Column(nullable = false)
	private Integer sex;
	
	@Column(nullable = false)
	private Integer sab;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getSeg() {
		return seg;
	}

	public void setSeg(Integer seg) {
		this.seg = seg;
	}

	public Integer getTer() {
		return ter;
	}

	public void setTer(Integer ter) {
		this.ter = ter;
	}

	public Integer getQua() {
		return qua;
	}

	public void setQua(Integer qua) {
		this.qua = qua;
	}

	public Integer getQui() {
		return qui;
	}

	public void setQui(Integer qui) {
		this.qui = qui;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getSab() {
		return sab;
	}

	public void setSab(Integer sab) {
		this.sab = sab;
	}
}
