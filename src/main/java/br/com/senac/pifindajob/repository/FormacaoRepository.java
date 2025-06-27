/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.pifindajob.repository;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rosilane
 */
public interface FormacaoRepository extends JpaRepository<FormacaoAcademica, Integer>{
    
}
