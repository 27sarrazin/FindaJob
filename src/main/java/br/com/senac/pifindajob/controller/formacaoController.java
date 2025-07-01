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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    
     // CREATE
    @PostMapping("/{idCandidato}")
    public ResponseEntity<FormacaoAcademica> criarFormacao(@RequestBody FormacaoAcademica formacao,
                                                            @PathVariable int idCandidato) {
        try {
            FormacaoAcademica nova = service.salvarFormacao(formacao, idCandidato);
            return ResponseEntity.ok(nova);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // READ - listar todas
    @GetMapping("/formacoes")
    public List<FormacaoAcademica> buscarFormacoes() {
        return service.buscarTodasFormacoes();
    }

    // READ - buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<FormacaoAcademica> buscarPorId(@PathVariable int id) {
        Optional<FormacaoAcademica> formacao = service.buscarPorId(id);
        return formacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FormacaoAcademica> atualizarForm(@PathVariable int id,
                                                           @RequestBody FormacaoAcademica novaFormacao) {
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

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFormacao(@PathVariable int id) {
        Optional<FormacaoAcademica> formacao = service.buscarPorId(id);

        if (formacao.isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

