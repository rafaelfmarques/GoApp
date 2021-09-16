package com.project.go.repository;

import com.project.go.entity.DiasSemana;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DiasSemanaRepository extends JpaRepository<DiasSemana, Long>{

    public DiasSemana findByDiasSemana(String diasSemana);
}
