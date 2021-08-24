package com.project.go.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_email")
    private String email;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "usuario_dt_nasc")
    private LocalDate dataNascimento;
    
    @Column(name = "usuario_senha")
    private String senha;
    
    @Column(name = "usuario_telefone")
    private String telefone;

    @Column(unique = true, name = "usuario_unico")
    private String userUnico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_end_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "personal_trainer_personal_id")
    private PersonalTrainer personalTrainer;
    
    @ManyToMany
    @JoinTable(name = "aut_user", 
        joinColumns = { @JoinColumn(name = "usuario_id") },
        inverseJoinColumns = { @JoinColumn(name = "aut_id") }
    
        )
    private Set<Autorizacao> autorizacao;

    @ManyToMany
    @JoinTable(name = "usuario_agendamento", 
        joinColumns = { @JoinColumn(name = "usuario_id")},
        inverseJoinColumns = { @JoinColumn(name = "agendamento_id") }
        )
    private Set<Agendamento> agendamento;


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

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PersonalTrainer getPersonalTrainer() {
        return this.personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public Set<Autorizacao> getAutorizacao() {
        return this.autorizacao;
    }

    public void setAutorizacao(Set<Autorizacao> autorizacao) {
        this.autorizacao = autorizacao;
    }

    public Set<Agendamento> getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Set<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }


}
