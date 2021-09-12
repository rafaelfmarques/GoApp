package com.project.go.repository;

import com.project.go.entity.AgendamentoStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoStatusRepository extends JpaRepository <AgendamentoStatus, Long> { 

    public AgendamentoStatus findByAgendamentoStatus(String agendamentoStatus);
    
}

