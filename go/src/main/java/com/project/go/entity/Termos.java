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
@Table(name = "termos_versao")
public class Termos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_versao")
    private Long versaoId;

    @JsonView(View.Usuario.class)
    @Column(name = "versao")
    private Float versao;

    @OneToMany(mappedBy = "termos")
    private Set<TermosUsuario> termosUsuario;

    public Long getVersaoId() {
        return this.versaoId;
    }

    public void setVersaoId(Long versaoId) {
        this.versaoId = versaoId;
    }

    public Float getVersao() {
        return this.versao;
    }

    public void setVersao(Float versao) {
        this.versao = versao;
    }

    public Set<TermosUsuario> getTermosUsuario() {
        return this.termosUsuario;
    }

    public void setTermosUsuario(Set<TermosUsuario> termosUsuario) {
        this.termosUsuario = termosUsuario;
    }

    
}
