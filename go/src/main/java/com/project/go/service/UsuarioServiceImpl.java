package com.project.go.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
    @Override
    public Usuario criaUsuario(String nome, String email, String senha, LocalDate dataNascimento, String telefone, String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade, String logradouro, String numero, String uf){
        
        Uf pesquisaUf = ufRepo.findByUfNome(uf);
        Autorizacao aut = autRepo.findByNomeAut(autorizacao);
        PersonalTrainer personal = personalRepo.findByEmailPersonal(personalTrainer);
        
        if(personal == null){
            throw new RegistroNaoEncontradoException("Personal Trainer inexistente");
        }
        if (aut == null ){
            throw new RegistroNaoEncontradoException("Autorizacao inexistente");
        }
        if (pesquisaUf == null){
            throw new RegistroNaoEncontradoException("UF inexistente");
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

    @Override
    public List<Usuario> buscarUsuarios() {

        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscaUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isPresent()){
            return usuarioOp.get();
        }
        throw new RegistroNaoEncontradoException("Usuário não encontrado");
    }

    @Override
    public Usuario criaAdmin(String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade,
            String logradouro, String numero, String uf) {
        
                Uf pesquisaUf = ufRepo.findByUfNome(uf);
                Autorizacao aut = autRepo.findByNomeAut(autorizacao);
                PersonalTrainer personal = personalRepo.findByEmailPersonal(personalTrainer);
        
                if(personal == null){
                    throw new RegistroNaoEncontradoException("Personal Trainer inexistente");
                }
                if (aut == null ){
                    throw new RegistroNaoEncontradoException("Autorizacao inexistente");
                }
                if (pesquisaUf == null){
                    throw new RegistroNaoEncontradoException("UF inexistente");
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

    @Override
    public Usuario removeAdmin(Long id) {
        Optional<Usuario> usuario = usuarioRepo.findById(id);

        if(usuario.isPresent()){
            usuarioRepo.delete(usuario.get());
        }
        return null;
    }

    @Override
    public Usuario removeUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepo.findById(id);

        if(usuario.isPresent()){
            usuarioRepo.delete(usuario.get());
        }
        return null;
    }

}
