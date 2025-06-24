/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.persistencia;

import br.com.senac.pifindajob.classes.Candidato;
import br.com.senac.pifindajob.classes.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 *
 * @author Rosilane
 */
public class EmpresaDao {
    public void cadastrar(Empresa empresa){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(empresa);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
            JPAUtil.closeEtityManager();
        }
    }
    
    public boolean verificarSeEmpresaCadastrada(int idUsuario) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(c) FROM Empresa c WHERE c.id_usuario.id = :idUsuario");
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
}
