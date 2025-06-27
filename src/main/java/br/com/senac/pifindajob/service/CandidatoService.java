/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.repository.CandidatoRepository;
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
    
    public ResponseEntity<Candidato> buscarCandidatoId(int id){
        Optional<Candidato> candidatoExistente = repository.findById(id);
        return ResponseEntity.ok(candidatoExistente.get());
    }
    
    public void excluirCandidato(int id){
        repository.deleteById(id);
    }
}
