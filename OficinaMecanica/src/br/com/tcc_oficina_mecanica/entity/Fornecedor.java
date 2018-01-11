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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "fornecedor")
@NamedQueries({ @NamedQuery(name = "Fornecedor.listar", query = "SELECT fornecedor FROM Fornecedor fornecedor"),
		@NamedQuery(name = "Fornecedor.buscarPorCodigo", query = "SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.codigo = :codigo") })
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo Razão Social é obrigatório")
	@Column(name = "razaosocial", length = 80, nullable = false)
	private String razaoSocialFornecedor;

	@NotEmpty(message = "O campo CNPJ é obrigatório")
	@Column(name = "cnpj", nullable = false)
	private String cnpjFornecedor;

	@Column(name = "inscricaoestadual", length = 20, nullable = true)
	private String inscricaoEstadualFornecedor;

	@Column(name = "nomefantasia", length = 70, nullable = true)
	private String nomeFantasiaFornecedor;

	@NotEmpty(message = "O campo representante é obrigatório")
	@Column(name = "representante", length = 60, nullable = false)
	private String representanteFornecedor;

	@NotEmpty(message = "O campo telefone é obrigatório")
	@Column(name = "telefone", length = 30, nullable = false)
	private String telefoneFornecedor;

	@Column(name = "telefonecontato", length = 30, nullable = true)
	private String telefoneContatoFornecedor;

	@NotEmpty(message = "O campo endereço é obrigatório")
	@Column(name = "endereco", length = 200, nullable = false)
	private String enderecoFornecedor;

	@Column(name = "cep", length = 15, nullable = true)
	private String cepFornecedor;

	@NotEmpty(message = "O campo cidade é obrigatório")
	@Column(name = "cidade", length = 50, nullable = false)
	private String cidadeFornecedor;

	@NotEmpty(message = "O campo estado é obrigatório")
	@Column(name = "estado", length = 10, nullable = false)
	private String estadoFornecedor;

	@Column(name = "email", length = 60, nullable = true)
	private String emailFornecedor;

	@Column(name = "homepage", length = 60, nullable = true)
	private String homePageFornecedor;

	@NotEmpty(message = "O campo peça é obrigatório")
	@Column(name = "peca", length = 50, nullable = false)
	private String pecaFornecedor;

	@NotNull(message = "O campo valor é obrigatório")
	@DecimalMin(value = "0.01", message = "Informe um valor válido")
	@DecimalMax(value = "999999.99", message = "Informe um valor válido")
	@Digits(integer = 6, fraction = 2, message = "Informe um valor válido para o campo Valor")
	@Column(name = "valor", precision = 8, scale = 2, nullable = false)
	private BigDecimal valorPecaFornecedor;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private Date dataCadastroFornecedor = new Date(System.currentTimeMillis());

	@NotEmpty(message = "O campo status é obrigatório")
	@Column(name = "status", length = 10, nullable = false)
	private String statusFornecedor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocialFornecedor() {
		return razaoSocialFornecedor;
	}

	public void setRazaoSocialFornecedor(String razaoSocialFornecedor) {
		this.razaoSocialFornecedor = razaoSocialFornecedor;
	}

	public String getInscricaoEstadualFornecedor() {
		return inscricaoEstadualFornecedor;
	}

	public void setInscricaoEstadualFornecedor(String inscricaoEstadualFornecedor) {
		this.inscricaoEstadualFornecedor = inscricaoEstadualFornecedor;
	}

	public String getNomeFantasiaFornecedor() {
		return nomeFantasiaFornecedor;
	}

	public void setNomeFantasiaFornecedor(String nomeFantasiaFornecedor) {
		this.nomeFantasiaFornecedor = nomeFantasiaFornecedor;
	}

	public String getRepresentanteFornecedor() {
		return representanteFornecedor;
	}

	public void setRepresentanteFornecedor(String representanteFornecedor) {
		this.representanteFornecedor = representanteFornecedor;
	}

	public String getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(String enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public String getCepFornecedor() {
		return cepFornecedor;
	}

	public void setCepFornecedor(String cepFornecedor) {
		this.cepFornecedor = cepFornecedor;
	}

	public String getCidadeFornecedor() {
		return cidadeFornecedor;
	}

	public void setCidadeFornecedor(String cidadeFornecedor) {
		this.cidadeFornecedor = cidadeFornecedor;
	}

	public String getEstadoFornecedor() {
		return estadoFornecedor;
	}

	public void setEstadoFornecedor(String estadoFornecedor) {
		this.estadoFornecedor = estadoFornecedor;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public String getHomePageFornecedor() {
		return homePageFornecedor;
	}

	public void setHomePageFornecedor(String homePageFornecedor) {
		this.homePageFornecedor = homePageFornecedor;
	}

	public String getPecaFornecedor() {
		return pecaFornecedor;
	}

	public void setPecaFornecedor(String pecaFornecedor) {
		this.pecaFornecedor = pecaFornecedor;
	}

	public BigDecimal getValorPecaFornecedor() {
		return valorPecaFornecedor;
	}

	public void setValorPecaFornecedor(BigDecimal valorPecaFornecedor) {
		this.valorPecaFornecedor = valorPecaFornecedor;
	}

	public Date getDataCadastroFornecedor() {
		return dataCadastroFornecedor;
	}

	public void setDataCadastroFornecedor(Date dataCadastroFornecedor) {
		this.dataCadastroFornecedor = dataCadastroFornecedor;
	}

	public String getStatusFornecedor() {
		return statusFornecedor;
	}

	public void setStatusFornecedor(String statusFornecedor) {
		this.statusFornecedor = statusFornecedor;
	}

	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}

	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}

	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public String getTelefoneContatoFornecedor() {
		return telefoneContatoFornecedor;
	}

	public void setTelefoneContatoFornecedor(String telefoneContatoFornecedor) {
		this.telefoneContatoFornecedor = telefoneContatoFornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", razaoSocialFornecedor=" + razaoSocialFornecedor + ", cnpjFornecedor="
				+ cnpjFornecedor + ", inscricaoEstadualFornecedor=" + inscricaoEstadualFornecedor
				+ ", nomeFantasiaFornecedor=" + nomeFantasiaFornecedor + ", representanteFornecedor="
				+ representanteFornecedor + ", telefoneFornecedor=" + telefoneFornecedor
				+ ", telefoneContatoFornecedor=" + telefoneContatoFornecedor + ", enderecoFornecedor="
				+ enderecoFornecedor + ", cepFornecedor=" + cepFornecedor + ", cidadeFornecedor=" + cidadeFornecedor
				+ ", estadoFornecedor=" + estadoFornecedor + ", emailFornecedor=" + emailFornecedor
				+ ", homePageFornecedor=" + homePageFornecedor + ", pecaFornecedor=" + pecaFornecedor
				+ ", valorPecaFornecedor=" + valorPecaFornecedor + ", dataCadastroFornecedor=" + dataCadastroFornecedor
				+ ", statusFornecedor=" + statusFornecedor + "]";
	}

}
