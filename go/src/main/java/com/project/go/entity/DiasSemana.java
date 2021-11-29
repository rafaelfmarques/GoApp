package com.project.go.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;

@Entity
@Table(name = "dias_semana")
public class DiasSemana {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dias_semana_id")
    private Long id;

    @JsonView(View.Agendamento.class)
    @Column(unique = true, name = "dias_semana")
    private String diasSemana;

    @OneToMany(mappedBy = "diasSemana")
    private Set<Agendamento> agendamento;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiasSemana() {
        return this.diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public Set<Agendamento> getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Set<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }


}
