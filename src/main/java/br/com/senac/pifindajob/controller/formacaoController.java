/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.controller;

import br.com.senac.pifindajob.classes.FormacaoAcademica;
import br.com.senac.pifindajob.service.FormacaoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rosilane
 */
@RestController
@RequestMapping("/formacao")
public class formacaoController {
    @Autowired
    private FormacaoService service;
    
    
    @GetMapping("/formacoes")
    public List<FormacaoAcademica> buscarFormacoes(){
        return service.buscarTodasFormacoes();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FormacaoAcademica> atualizarForm(@PathVariable int id, @RequestBody FormacaoAcademica novaFormacao) {
        Optional<FormacaoAcademica> formacaoExistente = service.buscarPorId(id);

        if (formacaoExistente.isPresent()) {
            FormacaoAcademica formacao = formacaoExistente.get();
            formacao.setCurso(novaFormacao.getCurso());
            formacao.setInstituicao(novaFormacao.getInstituicao());
            formacao.setCidade(novaFormacao.getCidade());

            FormacaoAcademica atualizada = service.salvarFormacao(formacao, formacao.getId_Candidato().getIdCandidato());

            return ResponseEntity.ok(atualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
