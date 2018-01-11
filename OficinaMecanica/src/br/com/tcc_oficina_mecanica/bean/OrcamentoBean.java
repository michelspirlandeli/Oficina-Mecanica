package br.com.tcc_oficina_mecanica.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.tcc_oficina_mecanica.dao.OrcamentoDAO;
import br.com.tcc_oficina_mecanica.entity.Orcamento;

@ManagedBean(name="orcamentoMB")@SessionScoped
public class OrcamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Orcamento> orcamentos;
	private Orcamento orcamento = new Orcamento();
	private OrcamentoDAO dao = new OrcamentoDAO();
	
	public void  Orcamento(){
		// TODO Auto-generated constructor stub
		listarOrcamentos();
	}

	 public void excluir(final int id_orcamento){
		 try{
		    dao.removeById(id_orcamento); 
		    System.out.println("Excluindo Orcamento com Sucesso");
		    listarOrcamentos();
	    }catch(Exception e){
			e.getMessage();
			e.getStackTrace();
		}
	 }  	 
	public void salvar(){
		try{
			if(orcamento == null){
				System.out.println("testeee");
				dao = new OrcamentoDAO();
				dao.persist(orcamento);
				orcamento = new Orcamento();//Limpa os campos do form
			} else {//editar 
				dao.merge(orcamento);
				orcamento = new Orcamento();
				listarOrcamentos();
			}
		} catch(Exception e){
			e.getMessage();
			e.getStackTrace();
		}
	}		 
	
	public void getByIdOrcamento(int id){
		OrcamentoDAO dao = new OrcamentoDAO();
		orcamento = dao.getById(id);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("orcamento.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public void listarOrcamentos(){
		this.orcamentos = dao.findAll();
	}
	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public OrcamentoDAO getDao() {
		return dao;
	}
	public void setDao(OrcamentoDAO dao) {
		this.dao = dao;
	}	
}
