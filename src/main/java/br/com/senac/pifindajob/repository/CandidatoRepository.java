/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.pifindajob.repository;

import br.com.senac.pifindajob.classes.Candidato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Rosilane
 */
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
     @Query("SELECT c FROM Candidato c WHERE LOWER(c.formacaoAcademica.curso) LIKE LOWER(CONCAT('%', :curso, '%'))")
    List<Candidato> buscarPorCurso(@Param("curso") String curso);
   boolean existsById_usuario_Id_usuario(int idUsuario);


}
