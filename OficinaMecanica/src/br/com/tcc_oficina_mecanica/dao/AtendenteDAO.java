package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.tcc_oficina_mecanica.entity.Atendente;

public class AtendenteDAO {

    protected EntityManager entityManager;
    
    public AtendenteDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public Atendente getById(final Long codigo) {
        return entityManager.find(Atendente.class, codigo);
    }
 
    @SuppressWarnings("unchecked")
    public List<Atendente> findAll() {
        return entityManager.createQuery("FROM " + Atendente.class.getName()).getResultList();
    }
 
    public void persist(Atendente atendente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(atendente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Atendente atendente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(atendente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Atendente atendente) {
        try {
            entityManager.getTransaction().begin();
            atendente = entityManager.find(Atendente.class, atendente.getCodigo());
            entityManager.remove(atendente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
     
    public void removeById(final Long codigo) {
        try {
        	Atendente atendente = getById(codigo);
            remove(atendente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}