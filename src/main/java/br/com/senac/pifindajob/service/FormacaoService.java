/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import br.com.senac.pifindajob.repository.CandidatoRepository;
import br.com.senac.pifindajob.repository.FormacaoRepository;
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
public class FormacaoService {
    @Autowired
    private FormacaoRepository repository;
    @Autowired
    private CandidatoRepository candidatoRepository;
    
      public FormacaoAcademica salvarFormacao(FormacaoAcademica formacao, int id) {
            Optional<Candidato> candidato = candidatoRepository.findById(id);
            if (candidato.isPresent()) {
                formacao.setId_Candidato(candidato.get());
                return repository.save(formacao);
            } else {
                throw new RuntimeException("Candidato com ID " + id + " não encontrado.");
            }
        }
      
        public Optional<FormacaoAcademica> buscarPorId(int id) {
            return repository.findById(id);
        }
        
        public List<FormacaoAcademica> buscarTodasFormacoes() {
            return repository.findAll();
        }
        

    public List<Candidato> buscarCandidatosPorCurso(String curso) {
        return repository.findByCursoIgnoreCase(curso)
                         .stream()
                         .map(FormacaoAcademica::getId_Candidato)
                         .distinct()
                         .toList();
    }

    
}
