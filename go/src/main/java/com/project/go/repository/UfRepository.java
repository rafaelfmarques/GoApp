package com.project.go.repository;

import com.project.go.entity.Uf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
    
    public Uf findByUfNome(String ufNome);

}
