package br.com.tcc_oficina_mecanica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc_oficina_mecanica.entity.Fornecedor;

public class FornecedorDAO {

	protected EntityManager entityManager;

	public FornecedorDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public Fornecedor getById(final Long id) {
		return entityManager.find(Fornecedor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> findAll() {
		return entityManager.createQuery("FROM " + Fornecedor.class.getName()).getResultList();
	}

	public void persist(Fornecedor fornecedor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(fornecedor);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Fornecedor fornecedor) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(fornecedor);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Fornecedor fornecedor) {
		try {
			entityManager.getTransaction().begin();
			fornecedor = entityManager.find(Fornecedor.class, fornecedor.getCodigo());
			entityManager.remove(fornecedor);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Fornecedor fornecedor = getById(id);
			remove(fornecedor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
