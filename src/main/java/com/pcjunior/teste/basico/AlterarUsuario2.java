package com.pcjunior.teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pcjunior.modelo.basico.Usuario;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        // REPONSÁVEL POR CRIAR O ENTITYMANAGER
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        // RESPONSÁVEL PELO CRUD
        EntityManager em = emf.createEntityManager();


        // INÍCIO DO PROCESSO DE BANCO
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, 2L);
        usuario.setNome("Rafaela");
        usuario.setEmail("rafaela@hotmail.com");
        //em.merge(usuario);
        System.out.println("Usuário(a) alterado: " + usuario.getEmail());

        // FIM DO PROCESSO DE BANCO
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
