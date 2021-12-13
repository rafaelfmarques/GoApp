package com.project.go.repository;

import org.springframework.stereotype.Repository;

import com.project.go.entity.Configuracao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {

    @Query(value = "SELECT valor FROM configuracao", nativeQuery = true)
    public Integer buscaValorPorNome();

    public Configuracao findByConfigNome(String configNome);
}
