package br.com.tcc_oficina_mecanica.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.tcc_oficina_mecanica.bean.JPAUtil;
import br.com.tcc_oficina_mecanica.dao.ServicoDAO;
import br.com.tcc_oficina_mecanica.entity.Servico;
import br.com.tcc_oficina_mecanica.util.FacesUtil;;

@ManagedBean(name = "servicoMB")
@ViewScoped
public class ServicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Servico> servicos;
	private List<Servico> servicoFiltrado;
	private Servico servico = new Servico();
	private ServicoDAO dao = new ServicoDAO();
	private String acao;
	private Long codigo;

	public ServicoBean() {

		listarServicos();
	}

	public void excluir() {
		try {
			dao.remove(servico);
			listarServicos();
			FacesUtil.mensagemOk("servico removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar remover o servico: " + e.getMessage());
		}
	}

	public void salvar() {
		try {
			if (servico == null) {
				EntityManager em = JPAUtil.getEntityManager();
				dao.persist(servico);
				servico = new Servico();// Limpa os campos do form
				em.close();
				FacesUtil.mensagemOk("servico cadastrado com sucesso. ");

			} else {// editar
				dao.merge(servico);
				FacesUtil.mensagemOk("servico atualizado com sucesso. ");

			}
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar Atualizar o servico. " + e.getMessage());
		}
	}

	public void getByIdServico() {
		try {
			if (codigo != null) {
				servico = dao.getById(codigo);

			} else {
				servico = new Servico();
			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar consultar o servico: " + e.getMessage());
		}
	}

	public void listarServicos() {
		try {
			this.servicos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar listar os servicos: " + e.getMessage());

		}
	}

	public void novo() {
		servico = new Servico();
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public ServicoDAO getDao() {
		return dao;
	}

	public void setDao(ServicoDAO dao) {
		this.dao = dao;
	}

	public List<Servico> getServicoFiltrado() {
		return servicoFiltrado;
	}

	public void setServicoFiltrado(List<Servico> servicoFiltrado) {
		this.servicoFiltrado = servicoFiltrado;
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

	@SuppressWarnings("unused")
	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);

	}

}
