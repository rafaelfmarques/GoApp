package com.project.go.entity;

import java.time.LocalDate;
import java.time.LocalTime;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;


@Entity
@Table(name = "agendamento")
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "agendamento_id")
    private Long id;


    @JsonView({View.Usuario.class, View.Agendamento.class})
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "data")
    private LocalDate data;

    @JsonView({View.Usuario.class, View.Agendamento.class})
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @JsonView({View.Usuario.class, View.Agendamento.class})
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "horario_fim")
    private LocalTime horarioFim;

    @JsonView({View.Usuario.class, View.Agendamento.class})
    @Column(name = "observacao")
    private String observacao;

    @JsonView(View.Agendamento.class)
    @ManyToMany(mappedBy = "agendamento")
    private Set<Usuario> usuario;

    @ManyToOne
    @JoinColumn(name = "dias_semana_id")
    @JsonView(View.Agendamento.class)
    private DiasSemana diasSemana;

    @ManyToOne
    @JsonView(View.Agendamento.class)
    @JoinColumn(name = "agendamento_status_id")
    private AgendamentoStatus agendamentoStatus;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate Data) {
        this.data = Data;
    }

    public LocalTime getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return this.horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
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
