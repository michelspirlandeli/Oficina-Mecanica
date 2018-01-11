package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.ServicoDAO;
import br.com.tcc_oficina_mecanica.entity.Servico;


public class ServicoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Servico serv = new Servico();
		serv.setNomeServico("Retifica de Cabeçote");
		serv.setDataCadastroServico(new Date());
		serv.setValorServico(new BigDecimal(800.69D));
		serv.setStatusServico("Ativo");

		Servico serv1 = new Servico();
		serv1.setNomeServico("Limpeza de Carburador");
		serv1.setDataCadastroServico(new Date());
		serv1.setValorServico(new BigDecimal(22.22D));
		serv1.setStatusServico("Ativo");

		Servico serv2 = new Servico();
		serv2.setNomeServico("Revisão de Freios");
		serv2.setDataCadastroServico(new Date());
		serv2.setValorServico(new BigDecimal(10.05D));
		serv2.setStatusServico("Inativo");

		ServicoDAO dao = new ServicoDAO();
		dao.persist(serv);
		dao.persist(serv1);
		dao.persist(serv2);

	}

	@Test
	@Ignore
	public void listar() {
		ServicoDAO dao = new ServicoDAO();

		List<Servico> servicos = dao.findAll();

		for (Servico servico : servicos) {
			System.out.println(servico);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ServicoDAO dao = new ServicoDAO();

		Servico s1 = dao.getById(2L);
		Servico s2 = dao.getById(5L);
		Servico s3 = dao.getById(7L);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ServicoDAO dao = new ServicoDAO();

		Servico servico = dao.getById(8L);
		if (servico != null) {
			dao.remove(servico);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		ServicoDAO dao = new ServicoDAO();
		dao.removeById(6L);
	}

	@Test
	@Ignore
	public void editar() {
		Servico serv = new Servico();
		serv.setCodigo(3L);
		serv.setDataCadastroServico(new Date());
		serv.setNomeServico("Limpeza de Bico");
		serv.setValorServico(new BigDecimal(52.62D));
		serv.setStatusServico("Ativo");
		

		ServicoDAO dao = new ServicoDAO();
		dao.merge(serv);
	}

}
