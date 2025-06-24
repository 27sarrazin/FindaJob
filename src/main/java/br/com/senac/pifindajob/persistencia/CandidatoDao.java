/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.persistencia;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.FormacaoAcademica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

/**
 *
 * @author Rosilane
 */
public class CandidatoDao {
    public int cadastrar(Candidato c){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c.getIdCandidato();
        }catch(Exception e){
            em.getTransaction().rollback();
            
             e.printStackTrace();
             return -1;
        }finally{
            JPAUtil.closeEtityManager();
            em.close();
        }
    }
    
    public boolean verificarSeCandidatoCadastrado(int idUsuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(c) FROM Candidato c WHERE c.id_usuario.id = :idUsuario");
            query.setParameter("idUsuario", idUsuario);
            Long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void excluirCandidato(int idUsuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Candidato candidato = em.createQuery("SELECT c FROM Candidato c WHERE c.id_usuario.id = :idUsuario", Candidato.class)
            .setParameter("idUsuario", idUsuario)
            .getSingleResult();

            em.remove(candidato);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao excluir candidato: " + e.getMessage());
        } finally {
            em.close();
        }
    }
     
    public void atualizarFormacaoAcademica(int idCandidato, String novoCurso, String novaInstituicao, String novaCidade){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            FormacaoAcademica formacao = em.createQuery("SELECT f FROM FormacaoAcademica f WHERE f.id_candidato.id_candidato = :idCandidato", FormacaoAcademica.class)
            .setParameter("idCandidato", idCandidato)
            .getSingleResult();

            formacao.setCurso(novoCurso);
            formacao.setInstituicao(novaInstituicao);
            formacao.setCidade(novaCidade);

            em.merge(formacao);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar formação acadêmica: " + e.getMessage());
        } finally {
            em.close();
        }
    }
     
    public Candidato buscarCandidatoPorUsuario(int idUsuario){
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("VERIFICANDO NO COMEÇO DO METODO AQUI>>>"+idUsuario);
        try {
            return em.createQuery(
                    "SELECT c FROM Candidato c WHERE c.id_usuario.id = :idUsuario", 
                    Candidato.class)
                    .setParameter("idUsuario", idUsuario)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("VERIFICANDO SE PASSOU O ID USUARIO AQUI>>>"+idUsuario);
            System.out.println("Nenhum candidato encontrado para o usuário com ID: " + idUsuario);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}
