/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.repository.CandidatoRepository;
import br.com.senac.pifindajob.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosilane
 */
@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public ResponseEntity<Candidato> buscarCandidatoId(int id){
        Optional<Candidato> candidatoExistente = repository.findById(id);
        return ResponseEntity.ok(candidatoExistente.get());
    }
    
    public void excluirCandidato(int id){
        repository.deleteById(id);
    }
    
     public Candidato salvar(Candidato candidato, int idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        candidato.setUsuario(usuario); // importante!
        return repository.save(candidato);
    }
     
    public List<Candidato> buscarPorCurso(String curso) {
        return repository.buscarPorCurso(curso);
    }
    
   public List<Candidato> buscarTodos() {
        return repository.findAll();
    }

  public boolean existePorUsuarioId(int idUsuario) {
    Usuario usuario = usuarioRepository.findById(idUsuario)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    return repository.existsByUsuario(usuario);
}


}
