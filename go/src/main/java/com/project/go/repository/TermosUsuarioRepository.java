package com.project.go.repository;

import com.project.go.entity.TermosUsuario;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TermosUsuarioRepository extends JpaRepository<TermosUsuario, Long> {

    public TermosUsuario findByConsentimentoContatoEmail(Boolean consentimentoContatoEmail);


}
