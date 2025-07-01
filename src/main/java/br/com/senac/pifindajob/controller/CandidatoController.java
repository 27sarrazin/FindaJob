/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.controller;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.Usuario;
import br.com.senac.pifindajob.service.CandidatoService;
import br.com.senac.pifindajob.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
      @Autowired
     private UsuarioService usuarioService;

    // CREATE
    @PostMapping("/{id}")
    public ResponseEntity<Candidato> cadastrar(@RequestBody Candidato candidato, @PathVariable int id) {
        Usuario usuario = usuarioService.buscarPorId(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    candidato.setUsuario(usuario); // ✅ CORRETO

    Candidato salvo = service.salvar(candidato);
    return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // READ - listar todos
    @GetMapping
    public List<Candidato> listarTodos() {
        return service.buscarTodos();
    }

    // READ - buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable int id) {
        ResponseEntity<Candidato> candidato = service.buscarCandidatoId(id);
        return candidato;
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Candidato> atualizar(@PathVariable int id, @RequestBody Candidato novoCandidato) {
        ResponseEntity<Candidato> existente = service.buscarCandidatoId(id);
        if (existente != null) {
            Candidato c = existente.getBody();
            c.setNome(novoCandidato.getNome());
            c.setCpf(novoCandidato.getCpf());
            c.setDescricaoCarreira(novoCandidato.getDescricaoCarreira());
            Candidato atualizado = service.salvar(c);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        ResponseEntity<Candidato> candidato = service.buscarCandidatoId(id);
        if (candidato != null) {
            service.excluirCandidato(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // READ - buscar por curso (já existente)
    @GetMapping("/buscarPorCurso")
    public List<Candidato> buscarPorCurso(@RequestParam String curso) {
        return service.buscarPorCurso(curso);
    }

    @PostMapping("/existePorUsuario")
public boolean verificaCandidatoPorUsuarioId(@RequestBody Usuario usuario) {
         // Optional<Usuario> existe = usuarioService.buscarPorId(idUsuario);
    return service.candidatoExistePorUsuarioId(usuario);
}

}
