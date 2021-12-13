package com.project.go.service;

import java.util.List;

import com.project.go.entity.Uf;
import com.project.go.repository.UfRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ufService")
public class UfServiceImpl implements UfService {

    @Autowired
    private UfRepository ufRepo;


    @Override
    public List<Uf> listaUfs() {   
        return ufRepo.findAll();
    }
    
}
