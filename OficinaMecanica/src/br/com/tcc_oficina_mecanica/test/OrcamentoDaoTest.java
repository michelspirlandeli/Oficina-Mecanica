package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.MecanicoDAO;
import br.com.tcc_oficina_mecanica.dao.OrcamentoDAO;
import br.com.tcc_oficina_mecanica.dao.VeiculoDAO;
import br.com.tcc_oficina_mecanica.entity.Mecanico;
import br.com.tcc_oficina_mecanica.entity.Orcamento;
import br.com.tcc_oficina_mecanica.entity.Veiculo;

public class OrcamentoDaoTest {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Orcamento orc = new Orcamento();
		orc.setNumeroOrcamento(000001L);
		orc.setDataCadastroOrcamento(new Date());
		orc.setObservacoesOrcamento("Teste");
		orc.setValorServicoOrcamento(new BigDecimal(200.00D));
		orc.setValorPecaOrcamento(new BigDecimal(85.97D));

		VeiculoDAO dao = new VeiculoDAO();
		Veiculo vei = dao.getById(4L);
		orc.setVeiculoOrcamento(vei);

		MecanicoDAO dao1 = new MecanicoDAO();
		Mecanico mec = dao1.getById(6L);
		orc.setMecanicoOrcamento(mec);

		orc.setValorTotalOrcamento(new BigDecimal(285.97D));
		orc.setDataEntregaOrcamento(new Date("2015/10/10"));
		orc.setHorarioEntregaOrcamento(new java.sql.Time(14, 25, 00));
		orc.setDataSaidaOrcamento(new Date("2015/10/14"));
		orc.setHorarioSaidaOrcamento(new java.sql.Time(14, 20, 00));
		orc.setGarantiaOrcamento("3 meses");

		Orcamento orc1 = new Orcamento();
		orc1.setNumeroOrcamento(000002L);
		orc1.setDataCadastroOrcamento(new Date());
		orc1.setObservacoesOrcamento("Testando");
		orc1.setValorServicoOrcamento(new BigDecimal(800.00D));
		orc1.setValorPecaOrcamento(new BigDecimal(52.78D));

		VeiculoDAO dao3 = new VeiculoDAO();
		Veiculo veic = dao3.getById(1L);
		orc1.setVeiculoOrcamento(veic);

		MecanicoDAO dao4 = new MecanicoDAO();
		Mecanico meca = dao4.getById(2L);
		orc1.setMecanicoOrcamento(meca);

		orc1.setValorTotalOrcamento(new BigDecimal(852.78D));
		orc1.setDataEntregaOrcamento(new Date("2015/09/28"));
		orc1.setHorarioEntregaOrcamento(new java.sql.Time(07, 22, 00));
		orc1.setDataSaidaOrcamento(new Date("2015/09/30"));
		orc1.setHorarioSaidaOrcamento(new java.sql.Time(18, 05, 00));
		orc1.setGarantiaOrcamento("6 meses");

		OrcamentoDAO dao2 = new OrcamentoDAO();
		dao2.persist(orc);
		dao2.persist(orc1);
	}

	@Test
	@Ignore
	public void listar() {
		OrcamentoDAO dao = new OrcamentoDAO();
		List<Orcamento> orcamentos = dao.findAll();

		for (Orcamento orcamento : orcamentos) {
			System.out.println(orcamento);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		OrcamentoDAO dao = new OrcamentoDAO();
		Orcamento s1 = dao.getById(2L);
		Orcamento s2 = dao.getById(5L);
		Orcamento s3 = dao.getById(9L);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

	@Test
	@Ignore
	public void excluir() {
		OrcamentoDAO dao = new OrcamentoDAO();

		Orcamento orcamento = dao.getById(11L);
		if (orcamento != null) {
			dao.remove(orcamento);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		OrcamentoDAO dao = new OrcamentoDAO();
		dao.removeById(12L);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {
		Orcamento orc = new Orcamento();
		orc.setCodigo(3L);
		orc.setDataCadastroOrcamento(new Date());
		orc.setDataEntregaOrcamento(new Date("2008/03/05"));
		orc.setDataSaidaOrcamento(new Date("2008/03/07"));
		orc.setGarantiaOrcamento("3 Meses");
		orc.setHorarioEntregaOrcamento(new java.sql.Time(9, 59, 00));
		orc.setHorarioSaidaOrcamento(new java.sql.Time(17, 32, 00));
		orc.setNumeroOrcamento(000004L);
		orc.setObservacoesOrcamento("Mais um teste de orçamento");
		orc.setValorPecaOrcamento(new BigDecimal(80.00D));
		orc.setValorServicoOrcamento(new BigDecimal(50.29D));
		orc.setValorTotalOrcamento(new BigDecimal(130.29D));

		VeiculoDAO dao3 = new VeiculoDAO();
		Veiculo veic = dao3.getById(8L);
		orc.setVeiculoOrcamento(veic);

		MecanicoDAO dao4 = new MecanicoDAO();
		Mecanico meca = dao4.getById(4L);
		orc.setMecanicoOrcamento(meca);

		OrcamentoDAO dao = new OrcamentoDAO();
		dao.merge(orc);
	}

}
