package br.com.tcc_oficina_mecanica.entity;

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

@Entity
@Table(name = "veiculo")
@NamedQueries({ @NamedQuery(name = "Veiculo.listar", query = "SELECT veiculo FROM Veiculo veiculo"),
	@NamedQuery(name = "Veiculo.buscarPorCodigo", query = "SELECT veiculo FROM Veiculo veiculo WHERE veiculo.codigo = :codigo") })
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@Column(name = "marca", length = 60, nullable = false)
	private String marcaVeiculo;

	@Column(name = "nome", length = 60, nullable = false)
	private String nomeVeiculo;

	@Column(name = "placa", length = 10, nullable = false)
	private String placaVeiculo;

	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabVeiculo;

	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModVeiculo;

	@Column(name = "renavam", nullable = true)
	private Long renavamVeiculo;

	@Column(name = "chassi", length = 30, nullable = true)
	private String chassiVeiculo;

	@Column(name = "combustivel", length = 20, nullable = false)
	private String combustivelVeiculo;

	@Column(name = "km", nullable = true)
	private Integer KmVeiculo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_cliente_codigo", referencedColumnName = "id_codigo")
	private Cliente clienteVeiculo;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable=false)
	private Date dataCadastroVeiculo = new Date(System.currentTimeMillis());

	@Column(name = "cor", length = 20, nullable = false)
	private String corVeiculo;

	@Column(name = "observacoes", length = 200, nullable = true)
	private String observacoesVeiculo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Integer getAnoFabVeiculo() {
		return anoFabVeiculo;
	}

	public void setAnoFabVeiculo(Integer anoFabVeiculo) {
		this.anoFabVeiculo = anoFabVeiculo;
	}

	public Integer getAnoModVeiculo() {
		return anoModVeiculo;
	}

	public void setAnoModVeiculo(Integer anoModVeiculo) {
		this.anoModVeiculo = anoModVeiculo;
	}

	public Long getRenavamVeiculo() {
		return renavamVeiculo;
	}

	public void setRenavamVeiculo(Long renavamVeiculo) {
		this.renavamVeiculo = renavamVeiculo;
	}

	public String getChassiVeiculo() {
		return chassiVeiculo;
	}

	public void setChassiVeiculo(String chassiVeiculo) {
		this.chassiVeiculo = chassiVeiculo;
	}

	public String getCombustivelVeiculo() {
		return combustivelVeiculo;
	}

	public void setCombustivelVeiculo(String combustivelVeiculo) {
		this.combustivelVeiculo = combustivelVeiculo;
	}

	public Integer getKmVeiculo() {
		return KmVeiculo;
	}

	public void setKmVeiculo(Integer kmVeiculo) {
		KmVeiculo = kmVeiculo;
	}

	public Cliente getClienteVeiculo() {
		return clienteVeiculo;
	}

	public void setClienteVeiculo(Cliente clienteVeiculo) {
		this.clienteVeiculo = clienteVeiculo;
	}

	public Date getDataCadastroVeiculo() {
		return dataCadastroVeiculo;
	}

	public void setDataCadastroVeiculo(Date dataCadastroVeiculo) {
		this.dataCadastroVeiculo = dataCadastroVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public String getObservacoesVeiculo() {
		return observacoesVeiculo;
	}

	public void setObservacoesVeiculo(String observacoesVeiculo) {
		this.observacoesVeiculo = observacoesVeiculo;
	}

	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", marcaVeiculo=" + marcaVeiculo + ", nomeVeiculo=" + nomeVeiculo
				+ ", placaVeiculo=" + placaVeiculo + ", anoFabVeiculo=" + anoFabVeiculo + ", anoModVeiculo="
				+ anoModVeiculo + ", renavamVeiculo=" + renavamVeiculo + ", chassiVeiculo=" + chassiVeiculo
				+ ", combustivelVeiculo=" + combustivelVeiculo + ", KmVeiculo=" + KmVeiculo + ", clienteVeiculo="
				+ clienteVeiculo + ", dataCadastroVeiculo=" + dataCadastroVeiculo + ", corVeiculo=" + corVeiculo
				+ ", observacoesVeiculo=" + observacoesVeiculo + "]";
	}
	
	

}

