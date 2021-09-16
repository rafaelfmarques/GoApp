package com.project.go.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoDto {

    private LocalDate data;
    private LocalTime horarioInicio;
    private String observacao;

    private String diasSemana;

    private String agendamentoStatus;

    private String userUnico;

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDiasSemana() {
        return this.diasSemana;
    }

    public void setDiasSemana(String diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getAgendamentoStatus() {
        return this.agendamentoStatus;
    }

    public void setAgendamentoStatus(String agendamentoStatus) {
        this.agendamentoStatus = agendamentoStatus;
    }

    public String getUserUnico() {
        return this.userUnico;
    }

    public void setUserUnico(String userUnico) {
        this.userUnico = userUnico;
    }
}
