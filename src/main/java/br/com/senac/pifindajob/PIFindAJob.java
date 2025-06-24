/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.senac.pifindajob;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 *
 * @author Rosilane
 */
public class PIFindAJob {

    public static void main(String[] args) {
        EntityManagerFactory fabricaEntidade = Persistence.createEntityManagerFactory("jobfind");

         EntityManager manager = fabricaEntidade.createEntityManager();
    }
}
