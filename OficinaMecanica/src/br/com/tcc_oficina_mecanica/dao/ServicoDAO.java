package br.com.tcc_oficina_mecanica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.tcc_oficina_mecanica.entity.Servico;

public class ServicoDAO {

	protected EntityManager entityManager;

	public ServicoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public Servico getById(final Long id) {
		return entityManager.find(Servico.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Servico> findAll() {
		return entityManager.createQuery("FROM " + Servico.class.getName()).getResultList();
	}

	public void persist(Servico servico) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(servico);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Servico servico) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(servico);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Servico servico) {
		try {
			entityManager.getTransaction().begin();
			servico = entityManager.find(Servico.class, servico.getCodigo());
			entityManager.remove(servico);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Servico servico = getById(id);
			remove(servico);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

