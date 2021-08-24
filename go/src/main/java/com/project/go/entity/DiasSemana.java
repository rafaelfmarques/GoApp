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
@Table(name = "dias_semana")
public class DiasSemana {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "dias_semana_id")
    private Long id;

    @Column(unique = true, nullable = false, name = "dias_semana")
    private String dias;

    @OneToMany(mappedBy = "diasSemana")
    private Set<Agendamento> agendamento;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDias() {
        return this.dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public Set<Agendamento> getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Set<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }


}
