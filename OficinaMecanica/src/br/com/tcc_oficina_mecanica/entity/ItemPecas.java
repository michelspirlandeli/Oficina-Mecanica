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
@Table(name = "itempeca")
@NamedQueries({
		@NamedQuery(name = "ItemPecas.listar", query = "SELECT itempecas FROM ItemPecas itempecas"),
		@NamedQuery(name = "ItemPecas.buscarPorCodigo", query = "SELECT itempecas FROM ItemPecas itempecas WHERE itempecas.codigo = :codigo") })
public class ItemPecas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itempec_codigo")
	private Long codigo;

	@Column(name = "quantidade", nullable = false)
	private Integer qtdItemPeca;

	@Column(name = "valor_parcial", precision = 9, scale = 2, nullable = false)
	private BigDecimal valorItemPeca;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_fornecedor_codigo", referencedColumnName = "id_codigo", nullable = false)
	private Fornecedor pecaItemPeca;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_orcamento_codigo", referencedColumnName = "id_codigo", nullable = false)
	private Orcamento orcamentoItemPeca;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Integer getQtdItemPeca() {
		return qtdItemPeca;
	}

	public void setQtdItemPeca(Integer qtdItemPeca) {
		this.qtdItemPeca = qtdItemPeca;
	}

	public BigDecimal getValorItemPeca() {
		return valorItemPeca;
	}

	public void setValorItemPeca(BigDecimal valorItemPeca) {
		this.valorItemPeca = valorItemPeca;
	}

	public Fornecedor getPecaItemPeca() {
		return pecaItemPeca;
	}

	public void setPecaItemPeca(Fornecedor pecaItemPeca) {
		this.pecaItemPeca = pecaItemPeca;
	}

	public Orcamento getOrcamentoItemPeca() {
		return orcamentoItemPeca;
	}

	public void setOrcamentoItemPeca(Orcamento orcamentoItemPeca) {
		this.orcamentoItemPeca = orcamentoItemPeca;
	}

	@Override
	public String toString() {
		return "ItemPecaOrcamento [codigo=" + codigo + ", qtdItemPeca=" + qtdItemPeca + ", valorItemPeca="
				+ valorItemPeca + ", pecaItemPeca=" + pecaItemPeca + ", orcamentoItemPeca=" + orcamentoItemPeca + "]";
	}

}
