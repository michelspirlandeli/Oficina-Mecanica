package br.com.tcc_oficina_mecanica.entity;

import java.math.BigDecimal;
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

@Entity
@Table(name = "servicos")
@NamedQueries({ @NamedQuery(name = "Servico.listar", query = "SELECT servico FROM Servico servico"),
		@NamedQuery(name = "Servico.buscarPorCodigo", query = "SELECT servico FROM Servico servico WHERE servico.codigo = :codigo") })

public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@Column(name = "nome", length = 80, nullable = false)
	private String nomeServico;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable=false)
	private Date dataCadastroServico = new Date(System.currentTimeMillis());

	@Column(name = "valor_servico", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorServico;

	@Column(name = "status", length = 10, nullable = false)
	private String statusServico;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Date getDataCadastroServico() {
		return dataCadastroServico;
	}

	public void setDataCadastroServico(Date dataCadastroServico) {
		this.dataCadastroServico = dataCadastroServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}

	@Override
	public String toString() {
		return "Servico [codigo=" + codigo + ", nomeServico=" + nomeServico + ", dataCadastroServico="
				+ dataCadastroServico + ", valorServico=" + valorServico + ", statusServico=" + statusServico + "]";
	}

}
