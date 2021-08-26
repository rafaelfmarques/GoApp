package com.project.go;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//import java.util.HashSet;

import java.time.LocalDate;

import com.project.go.entity.Usuario;

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


	@Test
	void contextLoads() {
	}

	void testaInsercaoService(){
		
		//Usuario usuario = userService.criaUsuario(nome, email, senha, dataNascimento, telefone, userUnico, personalTrainer, autorizacao, bairro, cidade, logradouro, numero, uf)		
		Usuario usuario = userService.criaUsuario("Luciana Carolina Porto", "lucianacarolinaporto@gmail.com", "lucianaporto2021", LocalDate.of(1987, 03, 2), "21985177426", "lucianaporto", "Fernando Tiago Bruno Drumond", "ROLE_USER", "Chácara Iguá", "Itaborái", "Alameda Dois", "130", "RJ");
		assertNotNull(usuario.getId());
	}

	@Test	
	void testeBuscaEnderecoPorEmail(){
		Usuario usuario = userRepo.buscaEnderecoPorNome("Alameda Dois");
		assertNotNull(usuario);
	}
	
	@Test
	void testeBuscaPersonalTrainerPorEmail(){
		Usuario usuario = userRepo.buscaPersonalTrainerPorEmail("fernandotiago@gmail.com");
		assertNotNull(usuario);
	}

	void testeBuscaUserUnicoAndEmail(){
		Usuario usuario = userRepo.findByUserUnicoAndEmail("sophiafernanda", "sophiafernanda@gmail.com");
		assertNotNull(usuario);
	}


}
