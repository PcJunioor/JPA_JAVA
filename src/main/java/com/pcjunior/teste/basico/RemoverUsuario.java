package com.pcjunior.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pcjunior.modelo.basico.Usuario;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        
        Usuario usuario = em.find(Usuario.class, 2L);
        
        if(usuario != null){
            System.out.println(usuario.getNome() + " removido com sucesso!!");
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }




        em.close();
        emf.close();
    }
}
