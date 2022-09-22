package com.pcjunior.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pcjunior.modelo.basico.Usuario;

public class ObterUsuario {
    public static void main(String[] args) {
        // REPONSÁVEL POR CRIAR O ENTITYMANAGER
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        // RESPONSÁVEL PELO CRUD
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 1L);
        System.out.println("id " + usuario.getId() + ": " + usuario.getNome());

        em.close();
        emf.close();
    }
    
}
