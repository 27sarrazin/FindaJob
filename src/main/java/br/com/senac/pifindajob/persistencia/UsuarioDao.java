/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.pifindajob.persistencia;
import br.com.senac.pifindajob.classes.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


/**
 *
 * @author Rosilane
 */
public class UsuarioDao {
    public static Usuario validateUser(Usuario usuario){
        Usuario user = null;
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta= em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha",Usuario.class);
            consulta.setParameter("email",usuario.getEmail());
            consulta.setParameter("senha",usuario.getSenha());
            user =  (Usuario) consulta.getSingleResult();
        }catch(Exception e){
           System.out.println("comando invalido!");
        }finally{
           em.close();
        }
        return user;
    }
    
    public boolean verificarSeUserCadastrado(String email){
        EntityManager em = JPAUtil.getEntityManager();
        try {
        Query query = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.email = :email");
        query.setParameter("email", email); 
        Long count = (Long) query.getSingleResult();
        return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void cadastrar(Usuario usuario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin(); 
            em.persist(usuario);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
            em.close();
        }
    }
    
    public static Usuario buscarPorEmail(String email){
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :email", Usuario.class);
            query.setParameter("email", "%" + email + "%");
            return (Usuario) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
