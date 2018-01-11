package br.com.tcc_oficina_mecanica.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "mecanico")
@NamedQueries({ @NamedQuery(name = "Mecanico.listar", query = "SELECT mecanico FROM Mecanico mecanico"),
		@NamedQuery(name = "Mecanico.buscarPorCodigo", query = "SELECT mecanico FROM Mecanico mecanico WHERE mecanico.codigo = :codigo") })
public class Mecanico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@Column(name = "nome", length = 80, nullable = false)
	private String nomeMecanico;

	@Column(name = "especialidade", length = 50, nullable = false)
	private String especialidadeMecanico;

	@Temporal(value = TemporalType.DATE)
	@Type(type = "date")
	@Column(name = "data_admissao", nullable = false)
	private Date dataAdmissaoMecanico;

	@Column(name = "estadocivil", length = 30, nullable = true)
	private String estadoCivilMecanico;

	@Column(name = "sexo", length = 10, nullable = false)
	private String sexoMecanico;

	@Column(name = "telefone", nullable = true)
	private Long telefoneMecanico;

	@Column(name = "celular", nullable = true)
	private Long celularMecanico;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable=false)
	private Date dataCadastroMecanico = new Date(System.currentTimeMillis());

	@Column(name = "status", length = 10, nullable = false)
	private String statusMecanico;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeMecanico() {
		return nomeMecanico;
	}

	public void setNomeMecanico(String nomeMecanico) {
		this.nomeMecanico = nomeMecanico;
	}

	public String getEspecialidadeMecanico() {
		return especialidadeMecanico;
	}

	public void setEspecialidadeMecanico(String especialidadeMecanico) {
		this.especialidadeMecanico = especialidadeMecanico;
	}

	public Date getDataAdmissaoMecanico() {
		return dataAdmissaoMecanico;
	}

	public void setDataAdmissaoMecanico(Date dataAdmissaoMecanico) {
		this.dataAdmissaoMecanico = dataAdmissaoMecanico;
	}

	public String getEstadoCivilMecanico() {
		return estadoCivilMecanico;
	}

	public void setEstadoCivilMecanico(String estadoCivilMecanico) {
		this.estadoCivilMecanico = estadoCivilMecanico;
	}

	public String getSexoMecanico() {
		return sexoMecanico;
	}

	public void setSexoMecanico(String sexoMecanico) {
		this.sexoMecanico = sexoMecanico;
	}

	public Long getTelefoneMecanico() {
		return telefoneMecanico;
	}

	public void setTelefoneMecanico(Long telefoneMecanico) {
		this.telefoneMecanico = telefoneMecanico;
	}

	public Long getCelularMecanico() {
		return celularMecanico;
	}

	public void setCelularMecanico(Long celularMecanico) {
		this.celularMecanico = celularMecanico;
	}

	public Date getDataCadastroMecanico() {
		return dataCadastroMecanico;
	}

	public void setDataCadastroMecanico(Date dataCadastroMecanico) {
		this.dataCadastroMecanico = dataCadastroMecanico;
	}

	public String getStatusMecanico() {
		return statusMecanico;
	}

	public void setStatusMecanico(String statusMecanico) {
		this.statusMecanico = statusMecanico;
	}

	@Override
	public String toString() {
		return "Mecanico [codigo=" + codigo + ", nomeMecanico=" + nomeMecanico
				+ ", especialidadeMecanico=" + especialidadeMecanico
				+ ", dataAdmissaoMecanico=" + dataAdmissaoMecanico
				+ ", estadoCivilMecanico=" + estadoCivilMecanico
				+ ", sexoMecanico=" + sexoMecanico + ", telefoneMecanico="
				+ telefoneMecanico + ", celularMecanico=" + celularMecanico
				+ ", dataCadastroMecanico=" + dataCadastroMecanico
				+ ", statusMecanico=" + statusMecanico + "]";
	}

}
