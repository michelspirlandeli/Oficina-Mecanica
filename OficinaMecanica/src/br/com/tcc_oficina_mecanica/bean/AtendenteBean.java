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
import br.com.tcc_oficina_mecanica.dao.AtendenteDAO;
import br.com.tcc_oficina_mecanica.entity.Atendente;
import br.com.tcc_oficina_mecanica.util.FacesUtil;;

@ManagedBean(name = "atendenteMB")
@ViewScoped
public class AtendenteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Atendente> atendentes;
	private List<Atendente> atendenteFiltrado;
	private Atendente atendente = new Atendente();
	private AtendenteDAO dao = new AtendenteDAO();
	private String acao;
	private Long codigo;

	public AtendenteBean() {

		listarAtendentes();
	}

	public void excluir() {
		try {
			dao.remove(atendente);
			listarAtendentes();
			FacesUtil.mensagemOk("Atendente removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar remover o atendente: " + e.getMessage());
		}
	}

	public void salvar() {
		try {
			if (atendente == null) {
				EntityManager em = JPAUtil.getEntityManager();
				dao.persist(atendente);
				atendente = new Atendente();// Limpa os campos do form
				em.close();
				FacesUtil.mensagemOk("Atendente cadastrado com sucesso. ");

			} else {// editar
				dao.merge(atendente);
				FacesUtil.mensagemOk("Atendente atualizado com sucesso. ");

			}
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar Atualizar o atendente. " + e.getMessage());
		}
	}

	public void getByIdAtendente() {
		try {
			if (codigo != null) {
				atendente = dao.getById(codigo);

			} else {
				atendente = new Atendente();
			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar consultar o atendente: " + e.getMessage());
		}
	}

	public void listarAtendentes() {
		try {
			this.atendentes = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar listar os atendentes: " + e.getMessage());

		}
	}

	public void novo() {
		atendente = new Atendente();
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public AtendenteDAO getDao() {
		return dao;
	}

	public void setDao(AtendenteDAO dao) {
		this.dao = dao;
	}

	public List<Atendente> getAtendenteFiltrado() {
		return atendenteFiltrado;
	}

	public void setAtendenteFiltrado(List<Atendente> atendenteFiltrado) {
		this.atendenteFiltrado = atendenteFiltrado;
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
