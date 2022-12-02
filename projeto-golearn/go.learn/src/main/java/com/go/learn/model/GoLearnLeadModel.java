package com.go.learn.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conduzir")
public class GoLearnLeadModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLead;
    @Column(length = 45)
    private String nome;
    @Column(length = 20)
    private String telefone;
    @Column
    private Date dataCadastro;
    @Column(length = 20)
    private String status_2;
    @Column 
    private Date dataNovoCadastro;
    @Column(length = 45)
    private String observacao;

    public Long getIdLead() {
        return idLead;
    }
    public void setIdLead(Long idLead) {
        this.idLead = idLead;
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
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public String getStatus_2() {
        return status_2;
    }
    public void setStatus_2(String status_2) {
        this.status_2 = status_2;
    }
    public Date getDataNovoCadastro() {
        return dataNovoCadastro;
    }
    public void setDataNovoCadastro(Date dataNovoCadastro) {
        this.dataNovoCadastro = dataNovoCadastro;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
