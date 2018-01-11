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

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
@NamedQueries({ @NamedQuery(name = "Cliente.listar", query = "SELECT cliente FROM Cliente cliente"),
		@NamedQuery(name = "Cliente.buscarPorCodigo", query = "SELECT cliente FROM Cliente cliente WHERE cliente.codigo = :codigo") })
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Column(name = "nome", length = 80, nullable = false)
	private String nomeCliente;

	@Column(name = "cpf_cnpj", nullable = true)
	private String cpfCnpjCliente;

	@Column(name = "rg_inscricaoestadual", length = 20, nullable = true)
	private String rgIeEstadualCliente;

	@Column(name = "apelido_nomefantasia", length = 80, nullable = true)
	private String apelidoNomeFantasiaCliente;
	

	@NotEmpty(message= "O campo endereço é obrigatório")
	@Column(name = "endereco", length = 200, nullable= false)
	private String enderecoCliente;
	
	@Column(name="cep", length=15, nullable=true)
	private String cepCliente;

	@NotEmpty(message= "O campo cidade é obrigatório")
	@Column(name="cidade", length=50, nullable=false)
	private String cidadeCliente;
	
	@NotEmpty(message= "O campo estado é obrigatório")
	@Column(name="estado", length=10, nullable=false)
	private String estadoCliente;
	
	

	@Column(name = "telefone", nullable = true)
	private String telefoneCliente;

	@NotEmpty(message = "O campo celular é obrigatório")
	@Column(name = "celular", nullable = false)
	private String celularCliente;

	@Column(name = "email", length = 60, nullable = true)
	private String emailCliente;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	private Date dataCadastroCliente = new Date(System.currentTimeMillis());

	@Temporal(value = TemporalType.DATE)
	@Type(type = "date")
	@Column(name = "data_nascimento", nullable = true)
	private Date dataNascimentoCliente;

	@Column(name = "estadocivil", length = 30, nullable = true)
	private String estadoCivilCliente;


	@Column(name = "sexo", length = 10, nullable = true)
	private String sexoCliente;

	@Column(name = "profissao", length = 50, nullable = true)
	private String profissaoCliente;

	@NotNull(message = "O campo renda é obrigatório")
	@DecimalMin(value = "0.01", message = "Informe um valor válido")
	@DecimalMax(value = "9999999.99", message = "Informe um valor válido")
	@Digits(integer = 7, fraction = 2, message = "Informe um valor válido para o campo renda.")
	@Column(name = "renda", precision = 9, scale = 2, nullable = false)
	private BigDecimal rendaCliente;

	@NotEmpty(message = "O campo status é obrigatório")
	@Column(name = "status", length = 10, nullable = false)
	private String statusCliente;

	@Column(name = "observacoes", length = 200, nullable = true)
	private String observacoesCliente;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getRgIeEstadualCliente() {
		return rgIeEstadualCliente;
	}

	public void setRgIeEstadualCliente(String rgIeEstadualCliente) {
		this.rgIeEstadualCliente = rgIeEstadualCliente;
	}

	public String getApelidoNomeFantasiaCliente() {
		return apelidoNomeFantasiaCliente;
	}

	public void setApelidoNomeFantasiaCliente(String apelidoNomeFantasiaCliente) {
		this.apelidoNomeFantasiaCliente = apelidoNomeFantasiaCliente;
	}

	

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public String getCidadeCliente() {
		return cidadeCliente;
	}

	public void setCidadeCliente(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Date getDataCadastroCliente() {
		return dataCadastroCliente;
	}

	public void setDataCadastroCliente(Date dataCadastroCliente) {
		this.dataCadastroCliente = dataCadastroCliente;
	}

	public Date getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public void setDataNascimentoCliente(Date dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	public String getEstadoCivilCliente() {
		return estadoCivilCliente;
	}

	public void setEstadoCivilCliente(String estadoCivilCliente) {
		this.estadoCivilCliente = estadoCivilCliente;
	}

	public String getSexoCliente() {
		return sexoCliente;
	}

	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}

	public String getProfissaoCliente() {
		return profissaoCliente;
	}

	public void setProfissaoCliente(String profissaoCliente) {
		this.profissaoCliente = profissaoCliente;
	}

	public BigDecimal getRendaCliente() {
		return rendaCliente;
	}

	public void setRendaCliente(BigDecimal rendaCliente) {
		this.rendaCliente = rendaCliente;
	}

	public String getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(String statusCliente) {
		this.statusCliente = statusCliente;
	}

	public String getObservacoesCliente() {
		return observacoesCliente;
	}

	public void setObservacoesCliente(String observacoesCliente) {
		this.observacoesCliente = observacoesCliente;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nomeCliente=" + nomeCliente + ", cpfCnpjCliente=" + cpfCnpjCliente
				+ ", rgIeEstadualCliente=" + rgIeEstadualCliente + ", apelidoNomeFantasiaCliente="
				+ apelidoNomeFantasiaCliente + ", enderecoCliente=" + enderecoCliente + ", cepCliente=" + cepCliente
				+ ", cidadeCliente=" + cidadeCliente + ", estadoCliente=" + estadoCliente + ", telefoneCliente="
				+ telefoneCliente + ", celularCliente=" + celularCliente + ", emailCliente=" + emailCliente
				+ ", dataCadastroCliente=" + dataCadastroCliente + ", dataNascimentoCliente=" + dataNascimentoCliente
				+ ", estadoCivilCliente=" + estadoCivilCliente + ", sexoCliente=" + sexoCliente + ", profissaoCliente="
				+ profissaoCliente + ", rendaCliente=" + rendaCliente + ", statusCliente=" + statusCliente
				+ ", observacoesCliente=" + observacoesCliente + "]";
	}

	
	
	


}
