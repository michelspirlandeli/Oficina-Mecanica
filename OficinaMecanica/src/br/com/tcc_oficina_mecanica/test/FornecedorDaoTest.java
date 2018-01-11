package br.com.tcc_oficina_mecanica.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.tcc_oficina_mecanica.dao.FornecedorDAO;
import br.com.tcc_oficina_mecanica.entity.Fornecedor;

public class FornecedorDaoTest {

	@Test
	//@Ignore
	public void salvar() {

		

		

		Fornecedor forn1 = new Fornecedor();
		forn1.setRazaoSocialFornecedor("Rogério Cardoso-ME");
		forn1.setCnpjFornecedor("78856123000123");
		forn1.setNomeFantasiaFornecedor("Mineirão AutoPeças");
		forn1.setInscricaoEstadualFornecedor("123.456.789.415");
		forn1.setRepresentanteFornecedor("Marcelo Crivella");
		forn1.setTelefoneFornecedor("16992857410");
		forn1.setTelefoneContatoFornecedor("1637248596");
		forn1.setEnderecoFornecedor("Rua Afonsso Pena 5265 Cidade Nova");
		forn1.setCepFornecedor("14.408-095");
        forn1.setCidadeFornecedor("Franca");
        forn1.setEstadoFornecedor("SP");
		forn1.setPecaFornecedor("Bateria");
		forn1.setValorPecaFornecedor(new BigDecimal(120.25D));
		forn1.setStatusFornecedor("Inativo");
		forn1.setDataCadastroFornecedor(new Date());
		forn1.setHomePageFornecedor("www.mineiraoautopecas.com.br");
		forn1.setEmailFornecedor("mineirao@hotmail.com");

		FornecedorDAO dao2 = new FornecedorDAO();
		dao2.persist(forn1);
	}
	
	@Test
    @Ignore
	public void listar() {
		FornecedorDAO dao = new FornecedorDAO();
		List<Fornecedor> fornecedores = dao.findAll();

		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedorDAO dao = new FornecedorDAO();
		Fornecedor s1 = dao.getById(2L);
		Fornecedor s2 = dao.getById(5L);
		Fornecedor s3 = dao.getById(7L);

		System.out.println(s1);
		System.out.println(s2);
	    System.out.println(s3);

	
	}
	
	@Test
	@Ignore
	public void excluir() {
		FornecedorDAO dao = new FornecedorDAO();

		Fornecedor fornecedor = dao.getById(6L);
		if (fornecedor != null) {
			dao.remove(fornecedor);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		FornecedorDAO dao = new FornecedorDAO();
		dao.removeById(3L);
	}

	
	@Test
	@Ignore
	public void editar() {
		Fornecedor forn = new Fornecedor();
		forn.setCodigo(4L);
		forn.setRazaoSocialFornecedor("Mauricio Souza ME");
		forn.setCnpjFornecedor("78945612000123");
		forn.setNomeFantasiaFornecedor("Loja das Peças");
		forn.setInscricaoEstadualFornecedor("789456456123");
		forn.setDataCadastroFornecedor(new Date());
		forn.setEmailFornecedor("lojadaspecas@hotmail.com");
		forn.setHomePageFornecedor("www.lojapecas.com.br");
		forn.setRepresentanteFornecedor("Romildo Garcia");
		forn.setPecaFornecedor("Pneu Traseiro");
		forn.setValorPecaFornecedor(new BigDecimal(150.87D));
		forn.setStatusFornecedor("Ativo");
		forn.setTelefoneContatoFornecedor("16992568974");
		forn.setTelefoneFornecedor("1638069874");


		
		

		FornecedorDAO dao1 = new FornecedorDAO();
		dao1.merge(forn);
	}

}
