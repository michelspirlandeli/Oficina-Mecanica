package br.com.tcc_oficina_mecanica.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("tcc_oficina_mecanica");

		@SuppressWarnings("unused")
		EntityManager manager = factory.createEntityManager();
		
		factory.close();

	}
}