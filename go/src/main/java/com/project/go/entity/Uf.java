package com.project.go.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "uf")
public class Uf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uf_id")
    private Long id;

    @Column(unique = true, name = "uf_nome")
    private String nome;

    @OneToMany(mappedBy = "uf")
    private Set<Endereco> endereco;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Endereco> getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }



}
