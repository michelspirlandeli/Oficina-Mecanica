package br.com.tcc_oficina_mecanica.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.tcc_oficina_mecanica.dao.MecanicoDAO;
import br.com.tcc_oficina_mecanica.entity.Mecanico;

public class MecanicoDaoTest {
	
	
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Mecanico mec = new Mecanico();
		mec.setNomeMecanico("Carlos José Santos");
		mec.setEspecialidadeMecanico("Eletricista");
		mec.setCelularMecanico(16992567841L);
		mec.setDataAdmissaoMecanico(new Date("2009/02/28"));
		mec.setDataCadastroMecanico(new Date());
		mec.setEstadoCivilMecanico("Casado");
		mec.setSexoMecanico("Masculino");
		mec.setStatusMecanico("Ativo");
		mec.setTelefoneMecanico(1637045896L);
		

		Mecanico meca = new Mecanico();
		meca.setNomeMecanico("Romeu Queiroz");
		meca.setEspecialidadeMecanico("Retificador");
		meca.setCelularMecanico(16991457841L);
		meca.setDataAdmissaoMecanico(new Date("2015/10/14"));
		meca.setDataCadastroMecanico(new Date());
		meca.setSexoMecanico("Masculino");
		meca.setStatusMecanico("inativo");
		
		

		MecanicoDAO dao = new MecanicoDAO();
		dao.persist(mec);
		dao.persist(meca);

	}
	
	@Test
    @Ignore
	public void listar() {
		MecanicoDAO dao = new MecanicoDAO();
		List<Mecanico> mecanicos = dao.findAll();

		for (Mecanico mecanico : mecanicos) {
			System.out.println(mecanico);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		MecanicoDAO dao = new MecanicoDAO();
		Mecanico s1 = dao.getById(2L);
		Mecanico s2 = dao.getById(5L);
		Mecanico s3 = dao.getById(9L);

		System.out.println(s1);
		System.out.println(s2);
	    System.out.println(s3);

	
	}
	
	@Test
	@Ignore
	public void excluir() {
		MecanicoDAO dao = new MecanicoDAO();
		
		Mecanico mecanico = dao.getById(3L);
		if (mecanico != null) {
			dao.remove(mecanico);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		MecanicoDAO dao = new MecanicoDAO();
		dao.removeById(7L);
	}

	
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {
		Mecanico meca = new Mecanico();
		meca.setCodigo(2L);
		meca.setNomeMecanico("Sergio Peres");
		meca.setEspecialidadeMecanico("Balanceador");
		meca.setCelularMecanico(16992245678L);
		meca.setDataAdmissaoMecanico(new Date("2001/01/01"));
		//meca.setDataCadastroMecanico(new Date());
		meca.setSexoMecanico("Masculino");
		meca.setStatusMecanico("Ativo");
		meca.setEstadoCivilMecanico("Casado");
		meca.setTelefoneMecanico(1637215689L);
		

		MecanicoDAO dao = new MecanicoDAO();
		dao.merge(meca);
	}

}
