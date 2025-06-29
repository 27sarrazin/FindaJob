/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.controller;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.service.FormacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rosilane
 */

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
      @Autowired
    private FormacaoService formacaoService;

    // Endpoint para empresas buscarem candidatos pela formação
    @GetMapping("/buscar-candidatos/{curso}")
    public List<Candidato> buscarCandidatosPorCurso(@PathVariable String curso) {
        return formacaoService.buscarCandidatosPorCurso(curso);
    }
}