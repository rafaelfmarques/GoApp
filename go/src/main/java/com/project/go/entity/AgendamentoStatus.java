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
@Table(name="agendamento_status")
public class AgendamentoStatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "agendamento_status_id")
    private Long id;
    
    @JsonView({ View.Agendamento.class })
    @Column(unique = true, nullable = false, name = "agendamento_status_nome")
    private String agendamentoStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "agendamentoStatus")
    private Set<Agendamento>agendamento;   


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgendamentoStatus() {
        return this.agendamentoStatus;
    }

    public void setAgendamentoStatus(String agendamentoStatus) {
        this.agendamentoStatus = agendamentoStatus;
    }

    public Set<Agendamento> getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Set<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }


}
