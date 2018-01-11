package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc_oficina_mecanica.entity.ItemPecas;

public class ItemPecasDAO {

    protected EntityManager entityManager;
    
    public ItemPecasDAO() {
        entityManager = getEntityManager();
    }
 
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
 
    public ItemPecas getById(final Long id) {
        return entityManager.find(ItemPecas.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<ItemPecas> findAll() {
        return entityManager.createQuery("FROM " + ItemPecas.class.getName()).getResultList();
    }
 
    public void persist(ItemPecas itemPecas) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(itemPecas);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(ItemPecas itemPecas) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(itemPecas);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(ItemPecas itemPecas) {
        try {
            entityManager.getTransaction().begin();
            itemPecas = entityManager.find(ItemPecas.class, itemPecas.getCodigo());
            entityManager.remove(itemPecas);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
     
    public void removeById(final Long id) {
        try {
        	ItemPecas itemPecas = getById(id);
            remove(itemPecas);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


