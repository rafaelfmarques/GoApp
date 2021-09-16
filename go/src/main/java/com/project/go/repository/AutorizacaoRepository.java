package com.project.go.repository;

import com.project.go.entity.Autorizacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {

    public Autorizacao findByNomeAut(String nomeAut);

}
