package br.com.tcc_oficina_mecanica.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tcc_oficina_mecanica");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();

	}

}
