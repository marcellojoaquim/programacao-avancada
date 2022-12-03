package com.go.learn.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GoLearnAlunoDto {
    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve ter no mínomo 3 caracteres! ")
    private String nome;
    
    @NotBlank(message = "O telefone é obrigatório!")
    private String telefone;
    private String endereco;
    private String cpf;

    @Email(message = "Insira um email válido!")
    @NotBlank(message = "O email é obrigatório!")
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    private String senha;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
