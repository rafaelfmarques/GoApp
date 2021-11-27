package com.project.go.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project.go.entity.Autorizacao;
import com.project.go.entity.Endereco;
import com.project.go.entity.PersonalTrainer;
import com.project.go.entity.Termos;
import com.project.go.entity.TermosUsuario;
import com.project.go.entity.Usuario;
import com.project.go.entity.Uf;

import com.project.go.repository.AutorizacaoRepository;
import com.project.go.repository.EnderecoRepository;
import com.project.go.repository.PersonalTrainerRepository;
import com.project.go.repository.TermosRepository;
import com.project.go.repository.TermosUsuarioRepository;
import com.project.go.repository.UfRepository;
import com.project.go.repository.UsuarioRepository;
import com.project.go.exception.RegistroExistente;
import com.project.go.exception.RegistroNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private TermosRepository termoRepo;

    @Autowired
    private TermosUsuarioRepository termoUserRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @Transactional
    @Override
    public Usuario criaUsuario(String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade,
            String logradouro, String numero, String uf, Float versao, Boolean consentimentoEndereco,
            Boolean consentimentoContatoEmail, Boolean consentimentoContatoTel, LocalDateTime criacao,
            LocalDateTime atualizado) {

        Uf pesquisaUf = ufRepo.findByUfNome(uf);
        Autorizacao aut = autRepo.findByNomeAut(autorizacao);
        PersonalTrainer personal = personalRepo.findByEmailPersonal(personalTrainer);
        Termos termoVersao = termoRepo.findByVersao(versao);

        if (personal == null) {
            throw new RegistroNaoEncontradoException("Personal Trainer inexistente");
        }
        if (aut == null) {
            throw new RegistroNaoEncontradoException("Autorizacao inexistente");
        }
        if (pesquisaUf == null) {
            throw new RegistroNaoEncontradoException("UF inexistente");
        }

        if (termoVersao == null) {
            throw new RegistroExistente("Versão do Termo não existe");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setEmail(email);
        usuario.setUserUnico(userUnico);
        usuario.setPersonalTrainer(personal);
        usuario.setTelefone(telefone);
        usuario.setAutorizacao(new HashSet<Autorizacao>());
        usuario.getAutorizacao().add(aut);

        TermosUsuario termosUsuario = new TermosUsuario();
        termosUsuario.setAtualizado(atualizado);
        termosUsuario.setConsentimentoContatoEmail(consentimentoContatoEmail);
        termosUsuario.setConsentimentoContatoTel(consentimentoContatoTel);
        termosUsuario.setConsentimentoEndereco(consentimentoEndereco);
        termosUsuario.setCriacao(criacao);
        termosUsuario.setUsuario(usuario);
        termosUsuario.setTermos(termoVersao);

        Endereco end = new Endereco();
        end.setBairro(bairro);
        end.setCidade(cidade);
        end.setLogradouro(logradouro);
        end.setNumero(numero);
        end.setUf(pesquisaUf);

        termoUserRepo.save(termosUsuario);

        usuario.setEndereco(end);

        end.setUsuario(usuario);

        usuarioRepo.save(usuario);

        endRepo.save(end);

        return usuario;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> buscarUsuarios() {

        return usuarioRepo.findAll();
    }

    @Override
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> relatorioUsuarios(){
        return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario buscaUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new RegistroNaoEncontradoException("Usuário não encontrado");
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Usuario criaAdmin(String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String autorizacao, String bairro, String cidade, String logradouro, String numero,
            String uf, Float versao, Boolean consentimentoEndereco, Boolean consentimentoContatoEmail,
            Boolean consentimentoContatoTel, LocalDateTime criacao, LocalDateTime atualizado) {

        Uf pesquisaUf = ufRepo.findByUfNome(uf);
        Autorizacao aut = autRepo.findByNomeAut(autorizacao);
        Termos termoVersao = termoRepo.findByVersao(versao);

        if (aut == null) {
            throw new RegistroNaoEncontradoException("Autorizacao inexistente");
        }
        if (pesquisaUf == null) {
            throw new RegistroNaoEncontradoException("UF inexistente");
        }

        if (termoVersao == null) {
            throw new RegistroExistente("Versão do Termo não existe");

        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setEmail(email);
        usuario.setUserUnico(userUnico);
        usuario.setTelefone(telefone);
        usuario.setAutorizacao(new HashSet<Autorizacao>());
        usuario.getAutorizacao().add(aut);

        TermosUsuario termosUsuario = new TermosUsuario();
        termosUsuario.setAtualizado(atualizado);
        termosUsuario.setConsentimentoContatoEmail(consentimentoContatoEmail);
        termosUsuario.setConsentimentoContatoTel(consentimentoContatoTel);
        termosUsuario.setConsentimentoEndereco(consentimentoEndereco);
        termosUsuario.setCriacao(criacao);
        termosUsuario.setUsuario(usuario);
        termosUsuario.setTermos(termoVersao);

        Endereco end = new Endereco();
        end.setBairro(bairro);
        end.setCidade(cidade);
        end.setLogradouro(logradouro);
        end.setNumero(numero);
        end.setUf(pesquisaUf);

        termoUserRepo.save(termosUsuario);

        usuario.setEndereco(end);

        end.setUsuario(usuario);

        usuarioRepo.save(usuario);

        endRepo.save(end);

        return usuario;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario removeAdmin(Long id) {

        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if (!usuarioOp.isPresent()) {
            throw new RegistroNaoEncontradoException("Usuário inexistente");
        }
        Usuario usuario = usuarioRepo.getById(id);
        usuario.setId(id);
        usuario.setNome(null);
        usuario.setEmail(null);
        usuario.setUserUnico(null);
        usuario.setTelefone(null);

        usuarioRepo.save(usuario);

        return usuario;

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario removeUsuario(Long id) {

        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if (!usuarioOp.isPresent()) {
            throw new RegistroNaoEncontradoException("Usuário inexistente");
        }
        Usuario usuario = usuarioRepo.getById(id);
        usuario.setId(id);
        usuario.setNome(null);
        usuario.setEmail(null);
        usuario.setUserUnico(null);
        usuario.setTelefone(null);

        usuarioRepo.save(usuario);

        return usuario;

    }

    @Override
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Usuario atualizaUsuario(Long id, String nome, String email, String senha, LocalDate dataNascimento,
            String telefone, String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade,
            String logradouro, String numero, String uf, Float versao, Boolean consentimentoEndereco,
            Boolean consentimentoContatoEmail, Boolean consentimentoContatoTel, LocalDateTime criacao,
            LocalDateTime atualizado) {

        Uf pesquisaUf = ufRepo.findByUfNome(uf);
        Autorizacao aut = autRepo.findByNomeAut(autorizacao);
        Termos termoVersao = termoRepo.findByVersao(versao);

        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if (!usuarioOp.isPresent()) {
            throw new RegistroNaoEncontradoException("Usuário inexistente");
        }

        if (aut == null) {
            throw new RegistroNaoEncontradoException("Autorizacao inexistente");
        }
        if (pesquisaUf == null) {
            throw new RegistroNaoEncontradoException("UF inexistente");
        }

        if (termoVersao == null) {
            throw new RegistroExistente("Versão do Termo não existe");

        }

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setEmail(email);
        usuario.setUserUnico(userUnico);
        usuario.setTelefone(telefone);
        usuario.setAutorizacao(new HashSet<Autorizacao>());
        usuario.getAutorizacao().add(aut);

        TermosUsuario termosUsuario = new TermosUsuario();
        termosUsuario.setAtualizado(atualizado);
        termosUsuario.setConsentimentoContatoEmail(consentimentoContatoEmail);
        termosUsuario.setConsentimentoContatoTel(consentimentoContatoTel);
        termosUsuario.setConsentimentoEndereco(consentimentoEndereco);
        termosUsuario.setCriacao(criacao);
        termosUsuario.setUsuario(usuario);
        termosUsuario.setTermos(termoVersao);

        Endereco end = new Endereco();
        end.setBairro(bairro);
        end.setCidade(cidade);
        end.setLogradouro(logradouro);
        end.setNumero(numero);
        end.setUf(pesquisaUf);

        termoUserRepo.save(termosUsuario);

        usuario.setEndereco(end);

        end.setUsuario(usuario);

        usuarioRepo.save(usuario);

        endRepo.save(end);

        return usuario;

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Usuario atualizaAdmin(Long id, String nome, String email, String senha, LocalDate dataNascimento,
            String telefone, String userUnico, String autorizacao, String bairro, String cidade, String logradouro,
            String numero, String uf, Float versao, Boolean consentimentoEndereco, Boolean consentimentoContatoEmail,
            Boolean consentimentoContatoTel, LocalDateTime criacao, LocalDateTime atualizado) {

        Uf pesquisaUf = ufRepo.findByUfNome(uf);
        Autorizacao aut = autRepo.findByNomeAut(autorizacao);
        Termos termoVersao = termoRepo.findByVersao(versao);

        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if (!usuarioOp.isPresent()) {
            throw new RegistroNaoEncontradoException("Usuário inexistente");
        }

        if (aut == null) {
            throw new RegistroNaoEncontradoException("Autorizacao inexistente");
        }
        if (pesquisaUf == null) {
            throw new RegistroNaoEncontradoException("UF inexistente");
        }

        if (termoVersao == null) {
            throw new RegistroExistente("Versão do Termo não existe");

        }

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setDataNascimento(dataNascimento);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setEmail(email);
        usuario.setUserUnico(userUnico);
        usuario.setTelefone(telefone);
        usuario.setAutorizacao(new HashSet<Autorizacao>());
        usuario.getAutorizacao().add(aut);

        TermosUsuario termosUsuario = new TermosUsuario();
        termosUsuario.setAtualizado(atualizado);
        termosUsuario.setConsentimentoContatoEmail(consentimentoContatoEmail);
        termosUsuario.setConsentimentoContatoTel(consentimentoContatoTel);
        termosUsuario.setConsentimentoEndereco(consentimentoEndereco);
        termosUsuario.setCriacao(criacao);
        termosUsuario.setUsuario(usuario);
        termosUsuario.setTermos(termoVersao);

        Endereco end = new Endereco();
        end.setBairro(bairro);
        end.setCidade(cidade);
        end.setLogradouro(logradouro);
        end.setNumero(numero);
        end.setUf(pesquisaUf);

        termoUserRepo.save(termosUsuario);

        usuario.setEndereco(end);

        end.setUsuario(usuario);

        usuarioRepo.save(usuario);

        endRepo.save(end);

        return usuario;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByUserUnico(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
                .authorities(usuario.getAutorizacao().stream().map(Autorizacao::getNome).collect(Collectors.toList())
                        .toArray(new String[usuario.getAutorizacao().size()]))
                .build();
    }

    @Override
    public List<Usuario> buscaUsuariosPorAutorizacao(String autorizacao) {
        
        List<Usuario> pesquisaUsuario = usuarioRepo.buscaUsuariosPorAutorizacao(autorizacao);
        if(pesquisaUsuario == null){
            throw new RegistroNaoEncontradoException("Usuário ou autorização inexistente");
        }

        return pesquisaUsuario;
    }

}
