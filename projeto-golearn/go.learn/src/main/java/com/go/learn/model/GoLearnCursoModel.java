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
public class GoLearnCursoModel implements Serializable{
 
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
	
	@Column
	private Integer seg;
	
	@Column
	private Integer ter;
	
	@Column
	private Integer qua;
	
	@Column
	private Integer qui;
	
	@Column
	private Integer sex;
	
	@Column
	private Integer sab;
	
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
