package br.com.tcc_oficina_mecanica.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.tcc_oficina_mecanica.bean.JPAUtil;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		JPAUtil.getEntityManager().close();

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		JPAUtil.getEntityManager().isOpen();
	}

}
