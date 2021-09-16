package com.project.go.repository;

import org.springframework.stereotype.Repository;

import com.project.go.entity.Termos;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TermosRepository extends JpaRepository<Termos, Long> {
    
    public Termos findByVersao(Float versao);

}
