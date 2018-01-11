package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc_oficina_mecanica.entity.Mecanico;

public class MecanicoDAO {

    protected EntityManager entityManager;
    
    public MecanicoDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public Mecanico getById(final Long id) {
        return entityManager.find(Mecanico.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<Mecanico> findAll() {
        return entityManager.createQuery("FROM " + Mecanico.class.getName()).getResultList();
    }
 
    public void persist(Mecanico mecanico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mecanico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Mecanico mecanico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(mecanico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Mecanico mecanico) {
        try {
            entityManager.getTransaction().begin();
            mecanico = entityManager.find(Mecanico.class, mecanico.getCodigo());
            entityManager.remove(mecanico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
     
    public void removeById(final Long id) {
        try {
        	Mecanico mecanico = getById(id);
            remove(mecanico);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
