package br.com.tcc_oficina_mecanica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name="usuario")
@NamedQueries({ @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
	@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.codigo = :codigo") })

public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ Codigo")
	private Long codigo;
	
	@Column(name = "login", length = 40, nullable = false)
	private String loginUsuario;
	
	@Column(name = "senha", length = 10, nullable = false)
	private String senhaUsuario;
	
	@Column(name = "funcao", length = 15, nullable = false)
	private String funcaoUsuario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(String funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario
				+ ", funcaoUsuario=" + funcaoUsuario + "]";
	}
	
	
	
	
	

}
