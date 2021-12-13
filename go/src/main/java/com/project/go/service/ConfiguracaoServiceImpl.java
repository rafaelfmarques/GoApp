package com.project.go.service;

import java.util.Optional;

import com.project.go.entity.Configuracao;
import com.project.go.repository.ConfiguracaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ConfiguracaoService")
@Transactional
public class ConfiguracaoServiceImpl implements ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configRepo;

    @Override
    public Configuracao alteraLimite(Long id, Long valor, String configNome) {

        Configuracao configuracao = new Configuracao();

        configuracao.setId(id);
        configuracao.setValor(valor);
        configuracao.setConfigNome(configNome);
        configRepo.save(configuracao);

        return configuracao;
    }
    
}
