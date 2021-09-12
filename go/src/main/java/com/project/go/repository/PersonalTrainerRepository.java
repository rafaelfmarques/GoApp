package com.project.go.repository;

import com.project.go.entity.PersonalTrainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, Long> {
    
    public PersonalTrainer findByEmailPersonal(String emailPersonal);
}
