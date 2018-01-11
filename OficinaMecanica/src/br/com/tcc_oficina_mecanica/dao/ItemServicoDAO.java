package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc_oficina_mecanica.entity.ItemServico;

public class ItemServicoDAO {

    protected EntityManager entityManager;
    
    public ItemServicoDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public ItemServico getById(final Long id) {
        return entityManager.find(ItemServico.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<ItemServico> findAll() {
        return entityManager.createQuery("FROM " + ItemServico.class.getName()).getResultList();
    }
 
    public void persist(ItemServico itemServico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(itemServico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(ItemServico itemServico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(itemServico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(ItemServico itemServico) {
        try {
            entityManager.getTransaction().begin();
            itemServico = entityManager.find(ItemServico.class, itemServico.getCodigo());
            entityManager.remove(itemServico);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
     
    public void removeById(final Long id) {
        try {
        	ItemServico itemServico = getById(id);
            remove(itemServico);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


