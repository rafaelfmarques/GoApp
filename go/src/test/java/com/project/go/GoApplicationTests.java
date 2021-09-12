package com.project.go;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.project.go.entity.Agendamento;
import com.project.go.entity.Usuario;
import com.project.go.service.AgendamentoService;
import com.project.go.service.UsuarioService;
import com.project.go.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class GoApplicationTests {


	@Autowired
	private UsuarioService userService;

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private AgendamentoService agendaService;

	@Test
	void contextLoads() {
	}

	@Test
	void testaInsercaoUsuario(){
		
		//Usuario usuario = userService.criaUsuario(nome, email, senha, dataNascimento, telefone, userUnico, personalTrainer, autorizacao, bairro, cidade, logradouro, numero, uf)		
		Usuario usuario = userService.criaUsuario("Sandra Simone Clarice Gonçalves", "sandrasimone@polifiltro.com.br", "sandrasimone__8786", LocalDate.now(), "47994337145", "sandrasimone", "fernandotiago@gmail.com", "ROLE_USER", "Tancredo Neves", "São Paulo", "Rua Pico da Neblina", "455", "SP");
		assertNotNull(usuario.getId());
	}

	void testaInsercaoAgendamento(){
		//java.sql.Time tempo = java.sql.Time.valueOf("20:00:00");
		//LocalTime localtime = tempo.toLocalTime();
		
		//agendaService.criaAgendamento(Data, horarioInicio, horarioFim, observacao, userUnico, diasSemana, agendamentoStatus)
		
		//assertNotNull(agendamento.getId());
	}

	
	void testeBuscaEnderecoPorEmail(){
		Usuario usuario = userRepo.buscaEnderecoPorNome("Alameda Dois");
		assertNotNull(usuario);
	}
	
	
	void testeBuscaPersonalTrainerPorEmail(){
		Usuario usuario = userRepo.buscaPersonalTrainerPorEmail("fernandotiago@gmail.com");
		assertNotNull(usuario);
	}


}
