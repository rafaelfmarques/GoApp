package com.project.go.service;

import java.util.List;

import com.project.go.entity.PersonalTrainer;

public interface PersonalTrainerService {

    public PersonalTrainer criaPersonal(String nomePersonal, String emailPersonal, String formacao);

    public PersonalTrainer excluiPersonal(Long id);

    public PersonalTrainer atualizaPersonal(Long id, String nomePersonal, String emailPersonal, String formacao);
    
    public List<PersonalTrainer> buscaPersonal();

    
}
