/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosilane
 */
@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;
    
    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(int id) {
        return repository.findById(id);
    }

    public Usuario atualizar(int id, Usuario novoUsuario) {
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setId_usuario(novoUsuario.getId_usuario());
                    usuario.setEmail(novoUsuario.getEmail());
                    usuario.setSenha(novoUsuario.getSenha());
                    usuario.setTipo_usuario(novoUsuario.getTipo_usuario());
                    return repository.save(usuario);
                }).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletar(int id) {
        repository.deleteById(id);
    } 
    
    public Optional<Usuario> autenticar(String email, String senha) {
    return repository.findByEmailAndSenha(email, senha);
}
}
