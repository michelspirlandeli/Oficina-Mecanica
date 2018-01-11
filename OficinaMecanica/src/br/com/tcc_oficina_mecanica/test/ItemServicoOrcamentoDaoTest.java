package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.ItemServicoDAO;

import br.com.tcc_oficina_mecanica.dao.OrcamentoDAO;
import br.com.tcc_oficina_mecanica.dao.ServicoDAO;

import br.com.tcc_oficina_mecanica.entity.ItemServico;

import br.com.tcc_oficina_mecanica.entity.Orcamento;
import br.com.tcc_oficina_mecanica.entity.Servico;

public class ItemServicoOrcamentoDaoTest {

	@Test
	@Ignore
	public void salvar() {
		ServicoDAO serv = new ServicoDAO();
		Servico servico = serv.getById(4L);

		OrcamentoDAO dao = new OrcamentoDAO();
		Orcamento orcamento = dao.getById(2L);

		ItemServico itemServicoOrcamento = new ItemServico();
		itemServicoOrcamento.setQtdItemServico(3);
		itemServicoOrcamento.setValorItemServico(new BigDecimal(12.98D));
		itemServicoOrcamento.setServicoItemServico(servico);
		itemServicoOrcamento.setOrcamentoItemServico(orcamento);

		ServicoDAO serve = new ServicoDAO();
		Servico servico1 = serve.getById(3L);

		OrcamentoDAO dao2 = new OrcamentoDAO();
		Orcamento orcamento1 = dao2.getById(4L);

		ItemServico item = new ItemServico();
		item.setQtdItemServico(1);
		item.setValorItemServico(new BigDecimal(500.67D));
		item.setServicoItemServico(servico1);
		item.setOrcamentoItemServico(orcamento1);

		ItemServicoDAO dao1 = new ItemServicoDAO();
		dao1.persist(itemServicoOrcamento);
		dao1.persist(item);
	}

	@Test
	@Ignore
	public void listar() {
		ItemServicoDAO dao = new ItemServicoDAO();
		List<ItemServico> itemServicos = dao.findAll();

		for (ItemServico itemServico : itemServicos) {
			System.out.println(itemServico);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemServicoDAO dao = new ItemServicoDAO();
		ItemServico itemServicoOrcamento = dao.getById(19L);
		ItemServico itemServicoOrcamento1 = dao.getById(2L);
		ItemServico itemServicoOrcamento2 = dao.getById(4L);

		System.out.println(itemServicoOrcamento);
		System.out.println(itemServicoOrcamento1);
		System.out.println(itemServicoOrcamento2);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemServicoDAO dao = new ItemServicoDAO();

		ItemServico itemServicoOrcamento = dao.getById(23L);
		if (itemServicoOrcamento != null) {
			dao.remove(itemServicoOrcamento);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		ItemServicoDAO dao = new ItemServicoDAO();
		dao.removeById(3L);
	}

	@Test
    @Ignore
	public void editar() {
		ItemServico item = new ItemServico();
		item.setCodigo(5L);
		item.setQtdItemServico(4);
		item.setValorItemServico(new BigDecimal(62.77D));

		ServicoDAO serv = new ServicoDAO();
		Servico servico = serv.getById(5L);
		item.setServicoItemServico(servico);

		OrcamentoDAO dao = new OrcamentoDAO();
		Orcamento orcamento = dao.getById(2L);
		item.setOrcamentoItemServico(orcamento);

		ItemServicoDAO dao1 = new ItemServicoDAO();
		dao1.merge(item);
	}

}
