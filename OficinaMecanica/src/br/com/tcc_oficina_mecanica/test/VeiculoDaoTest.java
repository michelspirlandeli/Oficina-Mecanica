package br.com.tcc_oficina_mecanica.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.ClienteDAO;
import br.com.tcc_oficina_mecanica.dao.VeiculoDAO;

import br.com.tcc_oficina_mecanica.entity.Cliente;
import br.com.tcc_oficina_mecanica.entity.Veiculo;

public class VeiculoDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Veiculo vei = new Veiculo();
		vei.setMarcaVeiculo("Volkswagen");
		vei.setNomeVeiculo("Gol 1.0 16V");
		vei.setPlacaVeiculo("CFK-9874");
		vei.setAnoFabVeiculo(2003);
		vei.setAnoModVeiculo(2004);
		vei.setCombustivelVeiculo("Gasolina");
		vei.setCorVeiculo("Branco");
		vei.setDataCadastroVeiculo(new Date());
		vei.setKmVeiculo(125000);
		vei.setChassiVeiculo("A4567898BSDE");
		vei.setRenavamVeiculo(1234567891234L);
		vei.setObservacoesVeiculo("Testando");

		ClienteDAO dao = new ClienteDAO();
		Cliente cli = dao.getById(3L);
		vei.setClienteVeiculo(cli);

		Veiculo veic = new Veiculo();
		veic.setMarcaVeiculo("Chevrolet");
		veic.setNomeVeiculo("Chevete");
		veic.setPlacaVeiculo("BKP-8545");
		veic.setAnoFabVeiculo(1987);
		veic.setAnoModVeiculo(1987);
		veic.setCombustivelVeiculo("Álcool");
		veic.setCorVeiculo("Prata");
		veic.setDataCadastroVeiculo(new Date());
		veic.setKmVeiculo(852600);

		ClienteDAO dao2 = new ClienteDAO();
		Cliente clie = dao2.getById(1L);
		veic.setClienteVeiculo(clie);

		VeiculoDAO dao1 = new VeiculoDAO();
		dao1.persist(vei);
		dao1.persist(veic);

	}

	@Test
	@Ignore
	public void listar() {
		VeiculoDAO dao = new VeiculoDAO();
		List<Veiculo> veiculos = dao.findAll();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo s1 = dao.getById(2L);
		Veiculo s2 = dao.getById(5L);
		Veiculo s3 = dao.getById(9L);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

	@Test
	@Ignore
	public void excluir() {
		VeiculoDAO dao = new VeiculoDAO();

		Veiculo veiculo = dao.getById(17L);
		if (veiculo != null) {
			dao.remove(veiculo);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		VeiculoDAO dao = new VeiculoDAO();
		dao.removeById(5L);
	}

	@Test
	@Ignore
	public void editar() {
		Veiculo vei = new Veiculo();
		vei.setCodigo(8L);
		vei.setAnoFabVeiculo(2015);
		vei.setAnoModVeiculo(2016);
		vei.setChassiVeiculo("ABC000235GHT8");
		vei.setCombustivelVeiculo("Flex");
		vei.setCorVeiculo("Vermelho");
		vei.setDataCadastroVeiculo(new Date());
		vei.setKmVeiculo(1500);
		vei.setMarcaVeiculo("Fiat");
		vei.setNomeVeiculo("Palio");
		vei.setObservacoesVeiculo("Veiculo zero kilômetro");
		vei.setPlacaVeiculo("GHT-8547");
		vei.setRenavamVeiculo(1237894567412L);
		

		ClienteDAO dao = new ClienteDAO();
		Cliente cli = dao.getById(5L);
		vei.setClienteVeiculo(cli);

		VeiculoDAO dao1 = new VeiculoDAO();
		dao1.merge(vei);
	}

}
