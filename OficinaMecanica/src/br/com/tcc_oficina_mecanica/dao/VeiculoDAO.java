package br.com.tcc_oficina_mecanica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tcc_oficina_mecanica.entity.Veiculo;

public class VeiculoDAO {

	protected EntityManager entityManager;

	public VeiculoDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public Veiculo getById(final Long id) {
		return entityManager.find(Veiculo.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> findAll() {
		return entityManager.createQuery("FROM " + Veiculo.class.getName()).getResultList();
	}

	public void persist(Veiculo veiculo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(veiculo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Veiculo veiculo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(veiculo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Veiculo veiculo) {
		try {
			entityManager.getTransaction().begin();
			veiculo = entityManager.find(Veiculo.class, veiculo.getCodigo());
			entityManager.remove(veiculo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Veiculo veiculo = getById(id);
			remove(veiculo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}