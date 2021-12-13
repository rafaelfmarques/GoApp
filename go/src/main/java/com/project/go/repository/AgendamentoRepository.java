package com.project.go.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.project.go.entity.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
    public Agendamento findByHorarioInicio(LocalTime horarioInicio);

    public Agendamento findByData(LocalDate data);   

    public List<Agendamento> findByUsuario_UserUnico(String userUnico);

    @Query(value = "SELECT COUNT(*) FROM agendamento WHERE (data =?1 AND horario_inicio = ?2)", nativeQuery = true)
    public Integer buscaQtdAgendamentosIguais(LocalDate data, LocalTime horarioInicio);

    @Query(value = "SELECT COUNT(*) FROM agendamento a INNER JOIN usuario_agendamento ua ON a.agendamento_id = ua.agendamento_id INNER JOIN usuario u ON u.usuario_id = ua.usuario_id WHERE u.usuario_unico = ?1 AND a.horario_inicio = ?2 AND a.data = ?3", nativeQuery = true)
    public Integer buscaQtdAgendamentosPorUsername(String userUnico, LocalTime horarioInicio, LocalDate data);
}
