package com.project.go.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;

@Entity
@Table(name = "autorizacao")
public class Autorizacao {
    
    @Id
    @Column(name = "aut_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({View.Usuario.class, View.UsuarioDados.class, View.Autorizacao.class})
    @Column(name = "aut_nome")
    private String nomeAut;

    @JsonView(View.Autorizacao.class)
    @ManyToMany(mappedBy = "autorizacao")
    private Set<Usuario> usuario;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nomeAut;
    }

    public void setNome(String nome) {
        this.nomeAut = nome;
    }

    public Set<Usuario> getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }


}
