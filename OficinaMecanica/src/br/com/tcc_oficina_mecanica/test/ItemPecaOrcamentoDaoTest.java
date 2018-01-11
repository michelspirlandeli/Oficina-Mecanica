package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.FornecedorDAO;
import br.com.tcc_oficina_mecanica.dao.ItemPecasDAO;


import br.com.tcc_oficina_mecanica.dao.OrcamentoDAO;

import br.com.tcc_oficina_mecanica.entity.Fornecedor;
import br.com.tcc_oficina_mecanica.entity.ItemPecas;


import br.com.tcc_oficina_mecanica.entity.Orcamento;


public class ItemPecaOrcamentoDaoTest {

	@Test
	@Ignore
	public void salvar() {
		FornecedorDAO dao = new FornecedorDAO();
		Fornecedor fornecedor = dao.getById(2L);

		OrcamentoDAO dao1 = new OrcamentoDAO();
		Orcamento orcamento = dao1.getById(3L);

		ItemPecas itemPecaOrcamento = new ItemPecas();
		itemPecaOrcamento.setQtdItemPeca(5);
		itemPecaOrcamento.setValorItemPeca(new BigDecimal(52.89D));
		itemPecaOrcamento.setPecaItemPeca(fornecedor);
		itemPecaOrcamento.setOrcamentoItemPeca(orcamento);

		FornecedorDAO dao2 = new FornecedorDAO();
		Fornecedor fornecedo = dao2.getById(4L);

		OrcamentoDAO dao3 = new OrcamentoDAO();
		Orcamento orcamento1 = dao3.getById(2L);

		ItemPecas itemPeca = new ItemPecas();
		itemPeca.setQtdItemPeca(8);
		itemPeca.setValorItemPeca(new BigDecimal(2523.78D));
		itemPeca.setPecaItemPeca(fornecedo);
		itemPeca.setOrcamentoItemPeca(orcamento1);

		ItemPecasDAO dao4 = new ItemPecasDAO();
		dao4.persist(itemPecaOrcamento);
		dao4.persist(itemPeca);
	}

	@Test
	@Ignore
	public void listar() {
		ItemPecasDAO dao = new ItemPecasDAO();
		List<ItemPecas> itemPecas = dao.findAll();

		for (ItemPecas itemPeca : itemPecas) {
			System.out.println(itemPeca);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemPecasDAO dao = new ItemPecasDAO();
		ItemPecas itemPecaOrcamento = dao.getById(19L);
		ItemPecas itemPecaOrcamento1 = dao.getById(2L);
		ItemPecas itemPecaOrcamento2 = dao.getById(4L);

		System.out.println(itemPecaOrcamento);
		System.out.println(itemPecaOrcamento1);
		System.out.println(itemPecaOrcamento2);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemPecasDAO dao = new ItemPecasDAO();

		ItemPecas itemPecaOrcamento = dao.getById(11L);
		if (itemPecaOrcamento != null) {
			dao.remove(itemPecaOrcamento);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		ItemPecasDAO dao = new ItemPecasDAO();
		dao.removeById(7L);
	}

	@Test
	@Ignore
	public void editar() {
		ItemPecas item = new ItemPecas();
		item.setCodigo(6L);
		item.setQtdItemPeca(2);
		item.setValorItemPeca(new BigDecimal(103.02D));

		FornecedorDAO dao = new FornecedorDAO();
		Fornecedor fornecedor = dao.getById(2L);

		OrcamentoDAO dao1 = new OrcamentoDAO();
		Orcamento orcamento = dao1.getById(2L);

		item.setPecaItemPeca(fornecedor);
		item.setOrcamentoItemPeca(orcamento);

		ItemPecasDAO dao2 = new ItemPecasDAO();
		dao2.merge(item);
	}

}
