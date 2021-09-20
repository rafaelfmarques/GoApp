package com.project.go.service;

import com.project.go.entity.Termos;
import com.project.go.exception.RegistroExistente;
import com.project.go.repository.TermosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("TermosService")
public class TermosServiceImpl implements TermosService {
    
    @Autowired
    private TermosRepository termoRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Termos criaVersaoTermo(Float versao) {
        Termos versaoTermo = termoRepo.findByVersao(versao);

        if (versaoTermo != null){
            throw new RegistroExistente("Versão já existente");
        }

        Termos termo = new Termos();
        termo.setVersao(versao);
        termoRepo.save(termo);

        return termo;
    }
}
