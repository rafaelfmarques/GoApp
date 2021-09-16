package com.project.go.controllers;

import java.time.LocalDate;

public class UsuarioDto {
    
    //Entidade Usuario
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String senha;
    private String telefone;
    private String userUnico;

    //Entidade Endereco
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String complemento;

    //Entidade Uf
    private String ufNome;

    //Entidade PersonalTrainer
    private String emailPersonal;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUserUnico() {
        return this.userUnico;
    }

    public void setUserUnico(String userUnico) {
        this.userUnico = userUnico;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUfNome() {
        return this.ufNome;
    }

    public void setUfNome(String ufNome) {
        this.ufNome = ufNome;
    }

    public String getEmailPersonal() {
        return this.emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }


}
