package com.project.go.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.project.go.entity.Agendamento;

public interface AgendamentoService {

    public Agendamento criaAgendamento(LocalDate Data, LocalTime horarioInicio, String observacao, String userUnico, String diasSemana, String agendamentoStatus);

    public Agendamento removeAgendamento(Long id);

    public List<Agendamento> buscarAgendamentos();

    public List<Agendamento>buscarAgendamentoPorUsuario(String userUnico);
}
