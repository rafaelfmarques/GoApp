package com.project.go.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Long id;

    @JsonView({ View.Usuario.class, View.UsuarioDados.class})
    @Column(name = "end_logradouro")
    private String logradouro;

    @JsonView({ View.Usuario.class, View.UsuarioDados.class})
    @Column(name = "end_numero")
    private String numero;

    @JsonView({ View.Usuario.class, View.UsuarioDados.class})
    @Column(name = "end_bairro")
    private String bairro;

    @JsonView({ View.Usuario.class, View.UsuarioDados.class})
    @Column(name = "end_cidade")
    private String cidade;

    @JsonView({ View.Usuario.class, View.UsuarioDados.class})
    @Column(name = "end_complemento")
    private String complemento;

    @ManyToOne
    @JsonView({ View.UsuarioDados.class})
    private Uf uf;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Usuario usuario;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Uf getUf() {
        return this.uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



   }
