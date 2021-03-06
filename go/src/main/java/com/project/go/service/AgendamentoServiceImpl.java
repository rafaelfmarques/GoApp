package com.project.go.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.project.go.entity.Agendamento;
import com.project.go.entity.AgendamentoStatus;
import com.project.go.entity.Configuracao;
import com.project.go.entity.DiasSemana;
import com.project.go.entity.Usuario;
import com.project.go.exception.RegistroNaoEncontradoException;
import com.project.go.exception.Exception;
import com.project.go.repository.AgendamentoRepository;
import com.project.go.repository.AgendamentoStatusRepository;
import com.project.go.repository.ConfiguracaoRepository;
import com.project.go.repository.DiasSemanaRepository;
import com.project.go.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("agendamentoService")
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private DiasSemanaRepository diasRepo;

    @Autowired
    private AgendamentoStatusRepository agendamentoStatusRepo;

    @Autowired
    private AgendamentoRepository agendamentoRepo;

    @Autowired
    private ConfiguracaoRepository configRepo;

    @PreAuthorize("isAuthenticated()")
    public Agendamento criaAgendamento(LocalDate Data, LocalTime horarioInicio, String observacao, String userUnico, String diasSemana, String agendamentoStatus, String configNome){

        Usuario pesquisaUser = userRepo.findByUserUnico(userUnico);
        DiasSemana pesquisaDias = diasRepo.findByDiasSemana(diasSemana);
        AgendamentoStatus pesquisaAgendamentoStatus = agendamentoStatusRepo.findByAgendamentoStatus(agendamentoStatus);
        Configuracao pesquisaConfig = configRepo.findByConfigNome(configNome);

        Integer pesquisaQtdAgendamentos = agendamentoRepo.buscaQtdAgendamentosIguais(Data, horarioInicio);
        Integer pegaValor = configRepo.buscaValorPorNome();

        Integer pesquisaQtdAgendamentosPorUser = agendamentoRepo.buscaQtdAgendamentosPorUsername(userUnico, horarioInicio, Data);

        if (pesquisaQtdAgendamentosPorUser >= 1){
            throw new Exception("J?? existe um agendamento nesse hor??rio.");
        }
    
        if(pesquisaQtdAgendamentos >= pegaValor){
            throw new Exception("Quantidade m??xima de usu??rios no mesmo hor??rio excedida.");
        }

        if(pesquisaUser == null || pesquisaDias == null || pesquisaAgendamentoStatus == null || Data == null || pesquisaConfig == null){
            throw new RegistroNaoEncontradoException("Dados inexistentes");
        }
        
        java.sql.Time tempo = java.sql.Time.valueOf(horarioInicio);
        LocalTime localtime = tempo.toLocalTime();
        LocalTime horarioFim = localtime.plusMinutes(60);
        
        Agendamento agendamento = new Agendamento();
        
        agendamento.setData(Data);
        agendamento.setHorarioInicio(horarioInicio);
        agendamento.setHorarioFim(horarioFim);
        agendamento.setObservacao(observacao);
        agendamento.setDiasSemana(pesquisaDias);
        agendamento.setAgendamentoStatus(pesquisaAgendamentoStatus);
        agendamento.setConfiguracao(pesquisaConfig);
        agendamento.setUsuario(new HashSet<Usuario>());
        agendamento.getUsuario().add(pesquisaUser);

        agendamentoRepo.save(agendamento);
        
        return agendamento;
    }


    @PreAuthorize("isAuthenticated()")
    @Override
    public Agendamento removeAgendamento(Long id) {
        Optional<Agendamento> agendamento = agendamentoRepo.findById(id);
        
        if(agendamento.isPresent()){
            agendamentoRepo.delete(agendamento.get());
        }
        return null;
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    public List<Agendamento> buscarAgendamentos() {
        
        return agendamentoRepo.findAll();
    }


    @Override
    //@PreAuthorize("isAuthenticated()")
    public List<Agendamento> buscarAgendamentoPorUsuario(String userUnico) {
        return agendamentoRepo.findByUsuario_UserUnico(userUnico);
    }
}
