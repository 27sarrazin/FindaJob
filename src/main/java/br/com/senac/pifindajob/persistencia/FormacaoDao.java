/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.persistencia;

import br.com.senac.pifindajob.classes.FormacaoAcademica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;


/**
 *
 * @author Rosilane
 */
public class FormacaoDao {
    
    public void salvar(FormacaoAcademica f){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback(); 
            throw e;
            
        }finally{
            JPAUtil.closeEtityManager();
        }
    }
   
    public void atualizar(FormacaoAcademica f){
        EntityManager em = JPAUtil.getEntityManager();
        try {
              em.getTransaction().begin();

            FormacaoAcademica formacaoExistente = em.find(FormacaoAcademica.class, f.getIdFormacao());

            if (formacaoExistente != null) {
                formacaoExistente.setCurso(f.getCurso());
                formacaoExistente.setInstituicao(f.getInstituicao());
                formacaoExistente.setCidade(f.getCidade());
                formacaoExistente.setId_Candidato(f.getId_Candidato());

                em.merge(formacaoExistente);
            } else {
                throw new RuntimeException("Formação acadêmica não encontrada para o candidato.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

   
    public FormacaoAcademica buscarFormacaoPorCandidato(int idCandidato){
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("VERIFICANDO NO COMEÇO DO METODO AQUI>>>"+idCandidato);
        try {
            return em.createQuery(
                    "SELECT f FROM FormacaoAcademica f WHERE f.id_Candidato.idCandidato = :idCandidato", 
                    FormacaoAcademica.class)
                    .setParameter("idCandidato", idCandidato)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("VERIFICANDO SE PASSOU O ID CANDIDATO AQUI>>>"+idCandidato);
            System.out.println("Nenhuma formação acadêmica encontrada para o candidato com ID: " + idCandidato);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
