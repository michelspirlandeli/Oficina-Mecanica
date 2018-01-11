package br.com.tcc_oficina_mecanica.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "itemservico")
@NamedQueries({
		@NamedQuery(name = "ItemServico.listar", query = "SELECT itemservico FROM ItemServico itemservico"),
		@NamedQuery(name = "ItemServico.buscarPorCodigo", query = "SELECT itemservico FROM ItemServico itemservico WHERE itemservico.codigo = :codigo") })
public class ItemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemser_codigo")
	private Long codigo;

	@Column(name = "quantidade", nullable = false)
	private Integer qtdItemServico;

	@Column(name = "valor_parcial", precision = 9, scale = 2, nullable = false)
	private BigDecimal valorItemServico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_servico_codigo", referencedColumnName = "id_codigo", nullable = false)
	private Servico servicoItemServico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_orcamento_codigo", referencedColumnName = "id_codigo", nullable = false)
	private Orcamento orcamentoItemServico;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQtdItemServico() {
		return qtdItemServico;
	}

	public void setQtdItemServico(Integer qtdItemServico) {
		this.qtdItemServico = qtdItemServico;
	}

	public BigDecimal getValorItemServico() {
		return valorItemServico;
	}

	public void setValorItemServico(BigDecimal valorItemServico) {
		this.valorItemServico = valorItemServico;
	}

	public Servico getServicoItemServico() {
		return servicoItemServico;
	}

	public void setServicoItemServico(Servico servicoItemServico) {
		this.servicoItemServico = servicoItemServico;
	}

	public Orcamento getOrcamentoItemServico() {
		return orcamentoItemServico;
	}

	public void setOrcamentoItemServico(Orcamento orcamentoItemServico) {
		this.orcamentoItemServico = orcamentoItemServico;
	}

	@Override
	public String toString() {
		return "ItemServicoOrcamento [codigo=" + codigo + ", qtdItemServico=" + qtdItemServico + ", valorItemServico="
				+ valorItemServico + ", servicoItemServico=" + servicoItemServico + ", orcamentoItemServico="
				+ orcamentoItemServico + "]";
	}

}
