package com.pcjunior.infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
    // ATRIBUTO STATIC SÓ É CRIADO UMA VEZ (QDO A CLASSE É CARREGADA PELO JAVA)
    // STATIC POIS ACESSARÁ APENAS UM BANCO DE DADO
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    // INICIALIZAR VARIÁVEIS STATIC
    // CHAMA APENAS QUANDO A CLASSE É CARREGADA PELO JAVA
    static{
        try {
            emf = Persistence.createEntityManagerFactory("exercicios-jpa");            
        } catch (Exception e) {
            // log4j  - CRIAR LOG
        }
    }
    public DAO(){
        this(null);
    }
    
    public DAO(Class<E> classe){
        this.classe = classe;
        em = emf.createEntityManager();
    }
    // TRANSAÇÕES
    public DAO<E> abrirTransacao(){
        em.getTransaction().begin();
        return this;
    }
    public DAO<E> fecharTransacao(){
        em.getTransaction().commit();
        return this;
    }

    // PROCESSO DE BANCO
    public DAO<E> incluir(E entidade){
        //abrirTransacao();
        em.persist(entidade);
        //fecharTransacao();
        
        return this;
    }
    public DAO<E> incluirFull(E entidade){
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public DAO<E> removerPorID(Object id) {            
        abrirTransacao();
        em.remove(em.find(classe, id));
        fecharTransacao();
        
        return this;        
    }

    
    public E obterPorID(Object id){
        return em.find(classe, id);
    }


    public List<E> obterTodos(){
        return this.obterTodos(10,0);
    }

    public List<E> obterTodos(int qtde, int deslocamento){
        if(classe == null){
            throw new UnsupportedOperationException("Classe nula");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    // FECHAR DAO
    public void fecharDAO(){
        em.close();

    }



    
}
