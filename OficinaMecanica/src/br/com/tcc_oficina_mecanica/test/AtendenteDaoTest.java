package br.com.tcc_oficina_mecanica.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.AtendenteDAO;
import br.com.tcc_oficina_mecanica.entity.Atendente;


public class AtendenteDaoTest {
	
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Atendente at = new Atendente();
		at.setNomeAtendente("Marcos Aurélio Garcia");
		at.setDataAdmissaoAtendente(new Date("2007/12/10"));
		at.setEstadoCivilAtendente("Viúvo");
		at.setSexoAtendente("Masculino");
		at.setTelefoneAtendente(1637068974L);
		at.setCelularAtendente(16992857410L);
		at.setDataCadastroAtendente(new Date());
		at.setStatusAtendente("Inativo");
		

		Atendente at1 = new Atendente();
		at1.setNomeAtendente("Juliano Ferreira");
		at1.setDataAdmissaoAtendente(new Date("2014/12/01"));
		at1.setSexoAtendente("Masculino");
		at1.setCelularAtendente(16993897458L);
		at1.setDataCadastroAtendente(new Date());
		at1.setStatusAtendente("Ativo");
		

		AtendenteDAO dao = new AtendenteDAO();
		dao.persist(at);
		dao.persist(at1);

	}
	
	@Test
    @Ignore
	public void listar() {
		AtendenteDAO dao = new AtendenteDAO();
		List<Atendente> atendentes = dao.findAll();

		for (Atendente atendente : atendentes) {
			System.out.println(atendente);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		AtendenteDAO dao = new AtendenteDAO();
		Atendente s1 = dao.getById(2L);
		Atendente s2 = dao.getById(5L);
		Atendente s3 = dao.getById(7L);

		System.out.println(s1);
		System.out.println(s2);
	    System.out.println(s3);

	
	}
	
	@Test
	@Ignore
	public void excluir() {
		AtendenteDAO dao = new AtendenteDAO();

		Atendente atendente = dao.getById(6L);
		if (atendente != null) {
			dao.remove(atendente);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		AtendenteDAO dao = new AtendenteDAO();
		dao.removeById(6L);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {
		Atendente atendente = new Atendente();
		atendente.setCodigo(5L);
		atendente.setCelularAtendente(16997777441L);
		atendente.setDataAdmissaoAtendente(new  Date("2002/11/25"));
		//atendente.setDataCadastroAtendente(new Date());
		atendente.setEstadoCivilAtendente("Divorciado");
		atendente.setNomeAtendente("Jão dos Reis Farias");
		atendente.setSexoAtendente("Masculino");
		atendente.setStatusAtendente("Ativo");
		atendente.setTelefoneAtendente(1637228545L);
		

		AtendenteDAO dao = new AtendenteDAO();
		dao.merge(atendente);
	}
}