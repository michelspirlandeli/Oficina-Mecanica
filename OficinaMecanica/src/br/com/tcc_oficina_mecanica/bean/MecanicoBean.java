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
import br.com.tcc_oficina_mecanica.dao.MecanicoDAO;
import br.com.tcc_oficina_mecanica.entity.Mecanico;
import br.com.tcc_oficina_mecanica.util.FacesUtil;;

@ManagedBean(name ="mecanicoMB")
@ViewScoped
public class MecanicoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Mecanico> mecanicos;
	private List<Mecanico> mecanicoFiltrado;
	private Mecanico mecanico = new Mecanico();
	private MecanicoDAO dao = new MecanicoDAO();
	private String acao;
	private Long codigo;

	public MecanicoBean() {

		listarMecanicos();
	}

	public void excluir() {
		try {
			dao.remove(mecanico);
			listarMecanicos();
			FacesUtil.mensagemOk("Mecanico removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar remover o Mecanico: " + e.getMessage());
		}
	}

	public void salvar() {
		try {
			if (mecanico == null) {
				EntityManager em = JPAUtil.getEntityManager();
				dao.persist(mecanico);
				mecanico = new Mecanico();// Limpa os campos do form
				em.close();
				FacesUtil.mensagemOk("Mecanico cadastrado com sucesso. ");

			} else {// editar
				dao.merge(mecanico);
				FacesUtil.mensagemOk("Mecanico atualizado com sucesso. ");

			}
		} catch (Exception e) {
			e.getMessage();
			e.getStackTrace();
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar Atualizar o Mecanico. " + e.getMessage());
		}
	}

	public void getByIdMecanico() {
		try {
			if (codigo != null) {
				mecanico = dao.getById(codigo);

			} else {
				mecanico = new Mecanico();
			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar consultar o Mecanico: " + e.getMessage());
		}
	}

	public void listarMecanicos() {
		try {
			this.mecanicos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar listar os Mecanicos: " + e.getMessage());

		}
	}

	public void novo() {
		mecanico = new Mecanico();
	}

	public List<Mecanico> getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(List<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public MecanicoDAO getDao() {
		return dao;
	}

	public void setDao(MecanicoDAO dao) {
		this.dao = dao;
	}

	public List<Mecanico> getMecanicoFiltrado() {
		return mecanicoFiltrado;
	}

	public void setMecanicoFiltrado(List<Mecanico> mecanicoFiltrado) {
		this.mecanicoFiltrado = mecanicoFiltrado;
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
