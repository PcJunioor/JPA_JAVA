package com.pcjunior.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pcjunior.modelo.basico.Usuario;

public class NovoUsuario {
    public static void main(String[] args) {

        // REPONSÁVEL POR CRIAR O ENTITYMANAGER
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        // RESPONSÁVEL PELO CRUD
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario = new Usuario("Luciana", "luciana@hotmail.com");
        

        em.getTransaction().begin();
        em.persist(novoUsuario);
        em.getTransaction().commit();

        System.out.println("id: " + novoUsuario.getId() + " incluído com sucesso!!");
        em.close();
        emf.close();
    }
    
}
