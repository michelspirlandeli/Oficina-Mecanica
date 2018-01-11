package br.com.tcc_oficina_mecanica.bean;


import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.tcc_oficina_mecanica.dao.FornecedorDAO;
import br.com.tcc_oficina_mecanica.entity.Fornecedor;
import br.com.tcc_oficina_mecanica.util.FacesUtil;

@ManagedBean(name="fornecedorMB")
@ViewScoped
public class FornecedorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Fornecedor> fornecedores;
	private Fornecedor fornecedor = new Fornecedor();
	private FornecedorDAO dao = new FornecedorDAO();
	private String acao;
	private Long codigo;
	
	public void  Fornecedor() {
	
		listarFornecedores();
	}

	 public void excluir(){
		 try{
		    dao.removeById(codigo);
		    listarFornecedores();
			FacesUtil.mensagemOk("Fornecedor removido com sucesso");

		   
	    }catch(Exception e){
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar remover o fornecedor: " + e.getMessage());

		}
	 }  	 
	public void salvar(){
		try{
			if(fornecedor == null){
				dao = new FornecedorDAO();
				dao.persist(fornecedor);
				fornecedor = new Fornecedor();//Limpa os campos do form
				FacesUtil.mensagemOk("Fornecedor cadastrado com sucesso. ");

			} else {//editar 
				dao.merge(fornecedor);
				fornecedor = new Fornecedor();
				listarFornecedores();
				FacesUtil.mensagemOk("Fornecedor atualizado com sucesso. ");

			}
		} catch(Exception e){
			e.getMessage();
			e.getStackTrace();
		}
	}		 
	
	public void getByIdFornecedor(){
		try {
			if (codigo != null) {
				fornecedor = dao.getById(codigo);
			} else {
				fornecedor = new Fornecedor();

			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar consultar o fornecedor: " + e.getMessage());

		}
	}

	public void listarFornecedores(){
		try{
		this.fornecedores = dao.findAll();
		}catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar listar os fornecedores: " + e.getMessage());

		}
	}
	
	public void novo() {
		fornecedor = new Fornecedor();
	}
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public FornecedorDAO getDao() {
		return dao;
	}
	public void setDao(FornecedorDAO dao) {
		this.dao = dao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	
	

}
