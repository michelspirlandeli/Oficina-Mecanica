package br.com.tcc_oficina_mecanica.bean;


import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.tcc_oficina_mecanica.dao.ClienteDAO;
import br.com.tcc_oficina_mecanica.entity.Cliente;
import br.com.tcc_oficina_mecanica.util.FacesUtil;

@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes;
	private Cliente cliente = new Cliente();
	private ClienteDAO dao = new ClienteDAO();
	private String acao;
	private Long codigo;

	public ClienteBean() {

		listarClientes();
	}

	public void excluir() {
		try {
			dao.remove(cliente);
			listarClientes();
			FacesUtil.mensagemOk("Cliente removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar remover o cliente: " + e.getMessage());

		}
	}

	public void salvar() {
		try {
			if (cliente == null) {
				dao = new ClienteDAO();
				dao.persist(cliente);
				cliente = new Cliente();// Limpa os campos do form
				FacesUtil.mensagemOk("Cliente cadastrado com sucesso. ");

			} else {// editar
				dao.merge(cliente);
				cliente = new Cliente();
				listarClientes();
				FacesUtil.mensagemOk("Cliente atualizado com sucesso. ");

			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getStackTrace();
		}
	}

	public void getByIdCliente() {
		try {
			if (codigo != null) {
				cliente = dao.getById(codigo);
			} else {
				cliente = new Cliente();

			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar consultar o cliente: " + e.getMessage());

		}
	}

	public void listarClientes() {
		try {
			this.clientes = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.mensagemErro("Erro ao tentar listar os clientes: " + e.getMessage());

		}
	}

	public void novo() {
		cliente = new Cliente();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
