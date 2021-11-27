package com.project.go.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;

@Entity
@Table(name = "personal_trainers")
public class PersonalTrainer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_id")
    private Long id;

    @JsonView({View.Usuario.class, View.UsuarioRelatorio.class, View.PersonalTrainer.class})
    @Column(name = "personal_nome")
    private String nomePersonal;

    @JsonView({View.Usuario.class, View.UsuarioRelatorio.class, View.PersonalTrainer.class})
    @Column(unique = true, name = "personal_email")
    private String emailPersonal;
    
    @JsonView({View.Usuario.class, View.UsuarioRelatorio.class, View.PersonalTrainer.class})
    @Column(name = "personal_formacao")
    private String formacao;

    @JsonView(View.PersonalTrainer.class)
    @OneToMany(mappedBy = "personalTrainer")
    private Set<Usuario> usuario;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nomePersonal;
    }

    public void setNome(String nomePersonal) {
        this.nomePersonal = nomePersonal;
    }

    public String getEmail() {
        return this.emailPersonal;
    }

    public void setEmail(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Set<Usuario> getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

}
