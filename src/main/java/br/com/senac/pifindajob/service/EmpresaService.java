/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.service;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.repository.CandidatoRepository;
import br.com.senac.pifindajob.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosilane
 */
@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> buscarCandidatosPorCurso(String curso) {
        return candidatoRepository.buscarPorCurso(curso);
    }
    
    
}
