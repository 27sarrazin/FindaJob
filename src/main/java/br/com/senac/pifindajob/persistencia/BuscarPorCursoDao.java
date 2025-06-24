/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.persistencia;

import br.com.senac.pifindajob.classes.Candidato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosilane
 */
public class BuscarPorCursoDao {
     public List<Candidato> listar(String curso) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Candidato> candidatos = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT c FROM Candidato c JOIN c.formacaoAcademica f WHERE LOWER(f.curso) LIKE LOWER(:curso)");
            consulta.setParameter("curso", "%" + curso + "%");
            candidatos = consulta.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
        return candidatos;
    }

}
