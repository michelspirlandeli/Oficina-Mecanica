package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.tcc_oficina_mecanica.entity.Orcamento;

public class OrcamentoDAO {

	protected EntityManager entityManager;

	public OrcamentoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public Orcamento getById(final Long id) {
		return entityManager.find(Orcamento.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Orcamento> findAll() {
		return entityManager.createQuery("FROM " + Orcamento.class.getName()).getResultList();
	}

	public void persist(Orcamento orcamento) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(orcamento);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Orcamento orcamento) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(orcamento);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Orcamento orcamento) {
		try {
			entityManager.getTransaction().begin();
			orcamento = entityManager.find(Orcamento.class, orcamento.getCodigo());
			entityManager.remove(orcamento);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Orcamento orcamento = getById(id);
			remove(orcamento);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
