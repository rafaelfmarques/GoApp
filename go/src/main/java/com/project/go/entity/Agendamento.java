package com.project.go.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "agendamento_id")
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, name = "horario_inicio")
    private LocalDateTime horarioInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, name = "horario_fim")
    private LocalDateTime horarioFim;

    @Column(name = "observacao")
    private String observacao;

    @ManyToMany(mappedBy = "agendamento")
    private Set<Usuario> usuario;

    @ManyToOne
    @JoinColumn(name = "dias_semana_id")
    private DiasSemana diasSemana;

    @ManyToOne
    @JoinColumn(name = "agendamento_status_id")
    private AgendamentoStatus agendamentoStatus;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(LocalDateTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDateTime getHorarioFim() {
        return this.horarioFim;
    }

    public void setHorarioFim(LocalDateTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<Usuario> getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public DiasSemana getDiasSemana() {
        return this.diasSemana;
    }

    public void setDiasSemana(DiasSemana diasSemana) {
        this.diasSemana = diasSemana;
    }

    public AgendamentoStatus getAgendamentoStatus() {
        return this.agendamentoStatus;
    }

    public void setAgendamentoStatus(AgendamentoStatus agendamentoStatus) {
        this.agendamentoStatus = agendamentoStatus;
    }


}
