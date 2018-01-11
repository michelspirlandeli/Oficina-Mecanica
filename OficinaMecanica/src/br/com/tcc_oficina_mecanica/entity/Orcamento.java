package br.com.tcc_oficina_mecanica.entity;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "orcamentos")
@NamedQueries({ @NamedQuery(name = "Orcamento.listar", query = "SELECT orcamento FROM Orcamento orcamento"),
		@NamedQuery(name = "Orcamento.buscarPorCodigo", query = "SELECT orcamento FROM Orcamento orcamento WHERE orcamento.codigo = :codigo") })
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@Column(name = "numero", nullable = false)
	private Long NumeroOrcamento;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable=false)
	private Date dataCadastroOrcamento = new Date(System.currentTimeMillis());

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_veiculo_codigo", referencedColumnName = "id_codigo")
	private Veiculo veiculoOrcamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_mecanico_codigo", referencedColumnName = "id_codigo")
	private Mecanico mecanicoOrcamento;

	@Column(name = "valor_total_peca", precision = 9, scale = 2, nullable = false)
	private BigDecimal valorPecaOrcamento;

	@Column(name = "valor_total_servico", precision = 9, scale = 2, nullable = false)
	private BigDecimal valorServicoOrcamento;

	@Column(name = "valor_total_orcamento", precision = 9, scale = 2, nullable = false)
	private BigDecimal valorTotalOrcamento;

	@Temporal(value = TemporalType.DATE)
	@Type(type = "date")
	@Column(name = "data_entrega", nullable = false)
	private Date dataEntregaOrcamento;

	// @Temporal(value = TemporalType.TIME)
	@Type(type = "time")
	@Column(name = "horario_entrega", nullable = false)
	private Date horarioEntregaOrcamento;

	@Temporal(value = TemporalType.DATE)
	@Type(type = "date")
	@Column(name = "data_saida", nullable = false)
	private Date dataSaidaOrcamento;

	@Temporal(value = TemporalType.TIME)
	@Type(type = "time")
	@Column(name = "horario_saida", nullable = false)
	private Date horarioSaidaOrcamento;

	@Column(name = "garantia", length = 20, nullable = true)
	private String garantiaOrcamento;

	@Column(name = "observacoes", length = 200, nullable = true)
	private String observacoesOrcamento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumeroOrcamento() {
		return NumeroOrcamento;
	}

	public void setNumeroOrcamento(Long numeroOrcamento) {
		NumeroOrcamento = numeroOrcamento;
	}

	public Date getDataCadastroOrcamento() {
		return dataCadastroOrcamento;
	}

	public void setDataCadastroOrcamento(Date dataCadastroOrcamento) {
		this.dataCadastroOrcamento = dataCadastroOrcamento;
	}

	public Veiculo getVeiculoOrcamento() {
		return veiculoOrcamento;
	}

	public void setVeiculoOrcamento(Veiculo veiculoOrcamento) {
		this.veiculoOrcamento = veiculoOrcamento;
	}

	public Mecanico getMecanicoOrcamento() {
		return mecanicoOrcamento;
	}

	public void setMecanicoOrcamento(Mecanico mecanicoOrcamento) {
		this.mecanicoOrcamento = mecanicoOrcamento;
	}

	public BigDecimal getValorPecaOrcamento() {
		return valorPecaOrcamento;
	}

	public void setValorPecaOrcamento(BigDecimal valorPecaOrcamento) {
		this.valorPecaOrcamento = valorPecaOrcamento;
	}

	public BigDecimal getValorServicoOrcamento() {
		return valorServicoOrcamento;
	}

	public void setValorServicoOrcamento(BigDecimal valorServicoOrcamento) {
		this.valorServicoOrcamento = valorServicoOrcamento;
	}

	public BigDecimal getValorTotalOrcamento() {
		return valorTotalOrcamento;
	}

	public void setValorTotalOrcamento(BigDecimal valorTotalOrcamento) {
		this.valorTotalOrcamento = valorTotalOrcamento;
	}

	public Date getDataEntregaOrcamento() {
		return dataEntregaOrcamento;
	}

	public void setDataEntregaOrcamento(Date dataEntregaOrcamento) {
		this.dataEntregaOrcamento = dataEntregaOrcamento;
	}

	public Date getHorarioEntregaOrcamento() {
		return horarioEntregaOrcamento;
	}

	public void setHorarioEntregaOrcamento(Date horarioEntregaOrcamento) {
		this.horarioEntregaOrcamento = horarioEntregaOrcamento;
	}

	public Date getDataSaidaOrcamento() {
		return dataSaidaOrcamento;
	}

	public void setDataSaidaOrcamento(Date dataSaidaOrcamento) {
		this.dataSaidaOrcamento = dataSaidaOrcamento;
	}

	public Date getHorarioSaidaOrcamento() {
		return horarioSaidaOrcamento;
	}

	public void setHorarioSaidaOrcamento(Date horarioSaidaOrcamento) {
		this.horarioSaidaOrcamento = horarioSaidaOrcamento;
	}

	public String getGarantiaOrcamento() {
		return garantiaOrcamento;
	}

	public void setGarantiaOrcamento(String garantiaOrcamento) {
		this.garantiaOrcamento = garantiaOrcamento;
	}

	public String getObservacoesOrcamento() {
		return observacoesOrcamento;
	}

	public void setObservacoesOrcamento(String observacoesOrcamento) {
		this.observacoesOrcamento = observacoesOrcamento;
	}

	@Override
	public String toString() {
		return "Orcamento [codigo=" + codigo + ", NumeroOrcamento=" + NumeroOrcamento + ", dataCadastroOrcamento="
				+ dataCadastroOrcamento + ", veiculoOrcamento=" + veiculoOrcamento + ", mecanicoOrcamento="
				+ mecanicoOrcamento + ", valorPecaOrcamento=" + valorPecaOrcamento + ", valorServicoOrcamento="
				+ valorServicoOrcamento + ", valorTotalOrcamento=" + valorTotalOrcamento + ", dataEntregaOrcamento="
				+ dataEntregaOrcamento + ", horarioEntregaOrcamento=" + horarioEntregaOrcamento
				+ ", dataSaidaOrcamento=" + dataSaidaOrcamento + ", horarioSaidaOrcamento=" + horarioSaidaOrcamento
				+ ", garantiaOrcamento=" + garantiaOrcamento + ", observacoesOrcamento=" + observacoesOrcamento + "]";
	}

}
