package com.project.go.service;

import java.time.LocalDate;
import java.util.HashSet;

import com.project.go.entity.Autorizacao;
import com.project.go.entity.Endereco;
import com.project.go.entity.PersonalTrainer;
import com.project.go.entity.Usuario;
import com.project.go.entity.Uf;

import com.project.go.repository.AutorizacaoRepository;
import com.project.go.repository.EnderecoRepository;
import com.project.go.repository.PersonalTrainerRepository;
import com.project.go.repository.UfRepository;
import com.project.go.repository.UsuarioRepository;

import com.project.go.exception.RegistroNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private PersonalTrainerRepository personalRepo;

    @Autowired
    private AutorizacaoRepository autRepo;

    @Autowired
    private UfRepository ufRepo;

    @Autowired
    private EnderecoRepository endRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Transactional
    public Usuario criaUsuario(String nome, String email, String senha, LocalDate dataNascimento, String telefone, String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade, String logradouro, String numero, String uf){
        
        Uf pesquisaUf = ufRepo.findByNome(uf);
        Autorizacao aut = autRepo.findByNome(autorizacao);
        PersonalTrainer personal = personalRepo.findByNome(personalTrainer);

        if(personal == null || aut == null || pesquisaUf == null){
            throw new RegistroNaoEncontradoException("Dados inexistentes");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setUserUnico(userUnico);
        usuario.setPersonalTrainer(personal);
        usuario.setTelefone(telefone);
        usuario.setAutorizacao(new HashSet<Autorizacao>());
        usuario.getAutorizacao().add(aut);
        

        Endereco end = new Endereco();
		end.setBairro(bairro);
		end.setCidade(cidade);
		end.setLogradouro(logradouro);
		end.setNumero(numero);
		end.setUf(pesquisaUf);

        usuario.setEndereco(end);

        end.setUsuario(usuario);

        usuarioRepo.save(usuario);

		endRepo.save(end);

        return usuario;
    }




}
