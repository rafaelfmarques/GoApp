package com.project.go.service;

import java.util.List;
import java.util.Optional;

import com.project.go.entity.PersonalTrainer;
import com.project.go.exception.RegistroExistente;
import com.project.go.exception.RegistroNaoEncontradoException;
import com.project.go.repository.PersonalTrainerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personalTrainerService")
@Transactional
public class PersonalTrainerServiceImpl implements PersonalTrainerService{

    @Autowired
    private PersonalTrainerRepository personalRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public PersonalTrainer criaPersonal(String nomePersonal, String emailPersonal, String formacao) {
        
        PersonalTrainer personal = personalRepo.findByEmailPersonal(emailPersonal);

        if(personal != null){
            throw new RegistroExistente("E-mail já utilizado");
        }

        PersonalTrainer personalTrainer = new PersonalTrainer();

        personalTrainer.setNome(nomePersonal);
        personalTrainer.setEmail(emailPersonal);
        personalTrainer.setFormacao(formacao);

        personalRepo.save(personalTrainer);

        return personalTrainer;
        
    }


    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public PersonalTrainer atualizaPersonal(Long id, String nomePersonal, String emailPersonal, String formacao) {
        
        Optional<PersonalTrainer> personalOp = personalRepo.findById(id);

        if (!personalOp.isPresent()) {
            throw new RegistroNaoEncontradoException("Personal inexistente");
        }

        PersonalTrainer personalTrainer = new PersonalTrainer();

        personalTrainer.setId(id);
        personalTrainer.setNome(nomePersonal);
        personalTrainer.setEmail(emailPersonal);
        personalTrainer.setFormacao(formacao);

        personalRepo.save(personalTrainer);

        return personalTrainer;
        

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public PersonalTrainer excluiPersonal(Long id) {
        Optional<PersonalTrainer> personal = personalRepo.findById(id);

        if (personal.isPresent()){
            personalRepo.delete(personal.get());
        }else{
            throw new RegistroNaoEncontradoException("Personal não encontrado");
        }

        return null;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<PersonalTrainer> buscaPersonal() {

        return personalRepo.findAll();
    }
    
}
