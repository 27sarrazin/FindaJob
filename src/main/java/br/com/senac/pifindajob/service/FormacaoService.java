/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import br.com.senac.pifindajob.repository.CandidatoRepository;
import br.com.senac.pifindajob.repository.FormacaoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    
      public void salvarFormacao(FormacaoAcademica formacao, int id) {
        Optional<Candidato> candidato = candidatoRepository.findById(id);
        if (candidato.isPresent()) {
            formacao.setId_Candidato(candidato.get());
            repository.save(formacao);
        } else {
            throw new RuntimeException("Candidato com ID " + id + " não encontrado.");
        }
    }
    
}
