package com.pcjunior.teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pcjunior.modelo.basico.Usuario;

public class ObterUsuarios {
    public static void main(String[] args) {
        // REPONSÁVEL POR CRIAR O ENTITYMANAGER
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        // RESPONSÁVEL PELO CRUD
        EntityManager em = emf.createEntityManager();

         String jpql = "select u from Usuario u";
         
        // TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        // query.setMaxResults(5);
        // List<Usuario> usuarios = query.getResultList();

 
        List<Usuario> usuarios = em.createQuery(jpql, Usuario.class)
                    .setMaxResults(5)
                    .getResultList();

        for(Usuario usuario: usuarios){
            System.out.println("Id: " + usuario.getId() + " - " + usuario.getEmail());
        }
        
        
        
        em.close();
        emf.close();
    }
    
    
}
