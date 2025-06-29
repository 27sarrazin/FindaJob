/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.controller;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.service.CandidatoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rosilane
 */

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
      @Autowired
    private CandidatoService service;

    @PostMapping
    public ResponseEntity<Candidato> cadastrar(@RequestBody Candidato candidato) {
        Candidato salvo = service.salvar(candidato);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    
    @GetMapping("/buscarPorCurso")
    public List<Candidato> buscarPorCurso(@RequestParam String curso) {
        return service.buscarPorCurso(curso);
    }

}
