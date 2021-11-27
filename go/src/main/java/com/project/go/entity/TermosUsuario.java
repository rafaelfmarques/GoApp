package com.project.go.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;

@Entity
@Table(name = "termos_usuario")
public class TermosUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_termo")
    private Long termoId;

    @JsonView({ View.Usuario.class, View.UsuarioRelatorio.class })
    @Column(name = "consentimento_endereco")
    private Boolean consentimentoEndereco;

    @JsonView({ View.Usuario.class, View.UsuarioRelatorio.class })
    @Column(name = "consentimento_contato_email")
    private Boolean consentimentoContatoEmail;
    
    @JsonView({ View.Usuario.class, View.UsuarioRelatorio.class })
    @Column(name = "consentimento_contato_tel")
    private Boolean consentimentoContatoTel;
    
    @JsonView({ View.Usuario.class, View.UsuarioRelatorio.class })
    @JsonFormat(pattern = "dd/MM/yyyyy HH:mm")
    @Column(name="criado_em")
    private LocalDateTime criacao;

    @JsonFormat(pattern = "dd/MM/yyyyy HH:mm")
    @Column(name = "atualizado_em")
    @JsonView({ View.Usuario.class, View.UsuarioRelatorio.class })
    private LocalDateTime atualizado;

    @ManyToOne
    @JoinColumn(name = "termo_id")
    private Termos termos; 

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Long getTermoId() {
        return this.termoId;
    }

    public void setTermoId(Long termoId) {
        this.termoId = termoId;
    }

    public Boolean isConsentimentoEndereco() {
        return this.consentimentoEndereco;
    }

    public Boolean getConsentimentoEndereco() {
        return this.consentimentoEndereco;
    }

    public void setConsentimentoEndereco(Boolean consentimentoEndereco) {
        this.consentimentoEndereco = consentimentoEndereco;
    }

    public Boolean isConsentimentoContatoEmail() {
        return this.consentimentoContatoEmail;
    }

    public Boolean getConsentimentoContatoEmail() {
        return this.consentimentoContatoEmail;
    }

    public void setConsentimentoContatoEmail(Boolean consentimentoContatoEmail) {
        this.consentimentoContatoEmail = consentimentoContatoEmail;
    }

    public Boolean isConsentimentoContatoTel() {
        return this.consentimentoContatoTel;
    }

    public Boolean getConsentimentoContatoTel() {
        return this.consentimentoContatoTel;
    }

    public void setConsentimentoContatoTel(Boolean consentimentoContatoTel) {
        this.consentimentoContatoTel = consentimentoContatoTel;
    }

    public LocalDateTime getCriacao() {
        return this.criacao;
    }

    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }

    public LocalDateTime getAtualizado() {
        return this.atualizado;
    }

    public void setAtualizado(LocalDateTime atualizado) {
        this.atualizado = atualizado;
    }

    public Termos getTermos() {
        return this.termos;
    }

    public void setTermos(Termos termos) {
        this.termos = termos;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
