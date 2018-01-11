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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "atendente")
@NamedQueries({ @NamedQuery(name = "Atendente.listar", query = "SELECT atendente FROM Atendente atendente"),
		@NamedQuery(name = "Atendente.buscarPorCodigo", query = "SELECT atendente FROM Atendente atendente WHERE atendente.codigo = :codigo") })
public class Atendente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Size(min = 1, max = 60)
	@Column(name = "nome", length = 60, nullable = false)
	private String nomeAtendente;

	@NotNull(message = "O campo data de admissão é obrigatório")
	@Temporal(value = TemporalType.DATE)
	@Type(type = "date")
	@Column(name = "data_admissao", nullable = false)
	private Date dataAdmissaoAtendente;

	@Column(name = "estado_civil", length = 30, nullable = true)
	private String estadoCivilAtendente;

	@NotEmpty(message = "O campo sexo é obrigatório")
	@Column(name = "sexo", length = 10, nullable = false)
	private String sexoAtendente;

	@Column(name = "telefone", nullable = true)
	private Long telefoneAtendente;

	@Column(name = "celular", nullable = true)
	private Long celularAtendente;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private Date dataCadastroAtendente = new Date(System.currentTimeMillis());

	@NotEmpty(message = "O campo status é obrigatório")
	@Column(name = "status", length = 10, nullable = false)
	private String statusAtendente;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public Date getDataAdmissaoAtendente() {
		return dataAdmissaoAtendente;
	}

	public void setDataAdmissaoAtendente(Date dataAdmissaoAtendente) {
		this.dataAdmissaoAtendente = dataAdmissaoAtendente;
	}

	public String getEstadoCivilAtendente() {
		return estadoCivilAtendente;
	}

	public void setEstadoCivilAtendente(String estadoCivilAtendente) {
		this.estadoCivilAtendente = estadoCivilAtendente;
	}

	public String getSexoAtendente() {
		return sexoAtendente;
	}

	public void setSexoAtendente(String sexoAtendente) {
		this.sexoAtendente = sexoAtendente;
	}

	public Long getTelefoneAtendente() {
		return telefoneAtendente;
	}

	public void setTelefoneAtendente(Long telefoneAtendente) {
		this.telefoneAtendente = telefoneAtendente;
	}

	public Long getCelularAtendente() {
		return celularAtendente;
	}

	public void setCelularAtendente(Long celularAtendente) {
		this.celularAtendente = celularAtendente;
	}

	public Date getDataCadastroAtendente() {
		return dataCadastroAtendente;
	}

	public void setDataCadastroAtendente(Date dataCadastroAtendente) {
		this.dataCadastroAtendente = dataCadastroAtendente;
	}

	public String getStatusAtendente() {
		return statusAtendente;
	}

	public void setStatusAtendente(String statusAtendente) {
		this.statusAtendente = statusAtendente;
	}

	@Override
	public String toString() {
		return "Atendente [id=" + codigo + ", nomeAtendente=" + nomeAtendente + ", dataAdmissaoAtendente="
				+ dataAdmissaoAtendente + ", estadoCivilAtendente=" + estadoCivilAtendente + ", sexoAtendente="
				+ sexoAtendente + ", telefoneAtendente=" + telefoneAtendente + ", celularAtendente=" + celularAtendente
				+ ", dataCadastroAtendente=" + dataCadastroAtendente + ", statusAtendente=" + statusAtendente + "]";
	}
}
