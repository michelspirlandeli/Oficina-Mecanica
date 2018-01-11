package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.ClienteDAO;
import br.com.tcc_oficina_mecanica.entity.Cliente;


public class ClienteDaoTest {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar() {

		Cliente cli = new Cliente();
		cli.setNomeCliente("Leandro Silva Freire");
		cli.setCpfCnpjCliente("12345678952");
		cli.setRgIeEstadualCliente("42.852.698-M");
		cli.setEnderecoCliente("Rua Afonsso Pena 5265 Cidade Nova");
		cli.setCepCliente("14.408-095");
        cli.setCidadeCliente("Franca");
        cli.setEstadoCliente("SP");
		cli.setTelefoneCliente("1637058957");
		cli.setCelularCliente("16991256879");
		cli.setDataCadastroCliente(new Date());
		cli.setEmailCliente("leandrosilva@outlook.com");
		cli.setDataNascimentoCliente(new Date("1958/06/25"));
		cli.setEstadoCivilCliente("Casado");
		cli.setSexoCliente("Masculino");
		cli.setProfissaoCliente("Analista de Sistemas");
		cli.setRendaCliente(new BigDecimal(1200.00D));
		cli.setStatusCliente("Ativo");
		cli.setObservacoesCliente("Teste Testando");

		Cliente cliente = new Cliente();
		cliente.setNomeCliente("Grupo Algar Telecomunicações LTDA");
		cliente.setCpfCnpjCliente("1245678952");
		cliente.setApelidoNomeFantasiaCliente("Algar Telecom");
		cliente.setRgIeEstadualCliente("123.456.789.123");	
		cliente.setEnderecoCliente("Rua Libero Badaro 5265 Cidade Nova");
		cliente.setCepCliente("14.408-095");
        cliente.setCidadeCliente("Franca");
        cliente.setEstadoCliente("SP");
        cliente.setTelefoneCliente("1637258974");
		cliente.setCelularCliente("16992568745");
		cliente.setEmailCliente("algartelecom@hotmail.com");
		cliente.setDataCadastroCliente(new Date());
		cliente.setProfissaoCliente("Prestadora de Serviços");
		cliente.setRendaCliente(new BigDecimal(1250.00D));
		cliente.setStatusCliente("Ativo");

		ClienteDAO dao2 = new ClienteDAO();
		dao2.persist(cli);
		dao2.persist(cliente);
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.findAll();

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ClienteDAO dao = new ClienteDAO();
		Cliente s1 = dao.getById(2L);
		Cliente s2 = dao.getById(5L);
		Cliente s3 = dao.getById(9L);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

	@Test
	@Ignore
	public void excluir() {
		ClienteDAO dao = new ClienteDAO();

		Cliente cliente = dao.getById(2L);
		if (cliente != null) {
			dao.remove(cliente);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		ClienteDAO dao = new ClienteDAO();
		dao.removeById(6L);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar() {
		Cliente cli = new Cliente();
		cli.setCodigo(3L);
		cli.setCelularCliente("16992589774");
		cli.setCpfCnpjCliente("12578498741L");
		cli.setDataCadastroCliente(new Date());
		cli.setDataNascimentoCliente(new Date("1995/12/31"));
		cli.setEmailCliente("reginaldo@gmail.com");
		
	
		
		
		cli.setEstadoCivilCliente("Casado");
		cli.setNomeCliente("Reginaldo Perez de Araújo");
		cli.setObservacoesCliente("Teste");
		cli.setProfissaoCliente("Advogado");
		cli.setRendaCliente(new BigDecimal(4000.99D));
		cli.setRgIeEstadualCliente("25.897.854-X");
		cli.setSexoCliente("Masculino");
		cli.setStatusCliente("Inativo");
		cli.setTelefoneCliente("1637235678");

		ClienteDAO dao1 = new ClienteDAO();
		dao1.merge(cli);
	}

}
