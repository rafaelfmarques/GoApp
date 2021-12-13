package com.project.go.service;

import com.project.go.entity.Configuracao;

public interface ConfiguracaoService {

    public Configuracao alteraLimite(Long id, Long valor, String configNome);
    
}
