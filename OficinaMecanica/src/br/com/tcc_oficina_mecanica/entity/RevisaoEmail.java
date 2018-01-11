package br.com.tcc_oficina_mecanica.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="revisaoEmail")
public class RevisaoEmail {
	@Id @GeneratedValue
	private int id;
	private String pessoaRevisaoEmail;
	private String emailRevisaoEmail;
	private String veiculoRevisaoEmail;
	private Date dataServicoRevisaoEmail;
	private Date dataProgramadaRevisaoEmail;
	private int kmRevisaoEmail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPessoaRevisaoEmail() {
		return pessoaRevisaoEmail;
	}
	public void setPessoaRevisaoEmail(String pessoaRevisaoEmail) {
		this.pessoaRevisaoEmail = pessoaRevisaoEmail;
	}
	
	public String getEmailRevisaoEmail() {
		return emailRevisaoEmail;
	}
	public void setEmailRevisaoEmail(String emailRevisaoEmail) {
		this.emailRevisaoEmail = emailRevisaoEmail;
	}
	public String getVeiculoRevisaoEmail() {
		return veiculoRevisaoEmail;
	}
	public void setVeiculoRevisaoEmail(String veiculoRevisaoEmail) {
		this.veiculoRevisaoEmail = veiculoRevisaoEmail;
	}
	public Date getDataServicoRevisaoEmail() {
		return dataServicoRevisaoEmail;
	}
	public void setDataServicoRevisaoEmail(Date dataServicoRevisaoEmail) {
		this.dataServicoRevisaoEmail = dataServicoRevisaoEmail;
	}
	public Date getDataProgramadaRevisaoEmail() {
		return dataProgramadaRevisaoEmail;
	}
	public void setDataProgramadaRevisaoEmail(Date dataProgramadaRevisaoEmail) {
		this.dataProgramadaRevisaoEmail = dataProgramadaRevisaoEmail;
	}
	public int getKmRevisaoEmail() {
		return kmRevisaoEmail;
	}
	public void setKmRevisaoEmail(int kmRevisaoEmail) {
		this.kmRevisaoEmail = kmRevisaoEmail;
	}
	

}
