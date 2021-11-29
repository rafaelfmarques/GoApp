package com.project.go.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.project.go.entity.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
    public Agendamento findByHorarioInicio(LocalTime horarioInicio);

    public Agendamento findByData(LocalDate data);   

    public List<Agendamento> findByUsuario_UserUnico(String userUnico);
}
