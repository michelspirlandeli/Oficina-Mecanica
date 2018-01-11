package br.com.tcc_oficina_mecanica.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="ordemServico")
public class OrdemServico {
	@Id @GeneratedValue
	private int id;
	private int numeroOrdemServico;
	private String veiculoOrdemServico;
	private Date dataEntradaOrdemServico;
	private int horarioEntradaOrdemServico;
	private Date dataSaidaOrdemServico;
	private int horarioSaidaOrdemServico;
	private String observacoesOrdemServico;
	private float valorOrdemServico;
	private int orcamentoOrdemServico;
	private String garantiaOrdemServico;
	private float valorPecaOrdemServico;
	private float valorTotaOrdemServico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroOrdemServico() {
		return numeroOrdemServico;
	}
	public void setNumeroOrdemServico(int numeroOrdemServico) {
		this.numeroOrdemServico = numeroOrdemServico;
	}
	public String getVeiculoOrdemServico() {
		return veiculoOrdemServico;
	}
	public void setVeiculoOrdemServico(String veiculoOrdemServico) {
		this.veiculoOrdemServico = veiculoOrdemServico;
	}
	public Date getDataEntradaOrdemServico() {
		return dataEntradaOrdemServico;
	}
	public void setDataEntradaOrdemServico(Date dataEntradaOrdemServico) {
		this.dataEntradaOrdemServico = dataEntradaOrdemServico;
	}
	public int getHorarioEntradaOrdemServico() {
		return horarioEntradaOrdemServico;
	}
	public void setHorarioEntradaOrdemServico(int horarioEntradaOrdemServico) {
		this.horarioEntradaOrdemServico = horarioEntradaOrdemServico;
	}
	public Date getDataSaidaOrdemServico() {
		return dataSaidaOrdemServico;
	}
	public void setDataSaidaOrdemServico(Date dataSaidaOrdemServico) {
		this.dataSaidaOrdemServico = dataSaidaOrdemServico;
	}
	public int getHorarioSaidaOrdemServico() {
		return horarioSaidaOrdemServico;
	}
	public void setHorarioSaidaOrdemServico(int horarioSaidaOrdemServico) {
		this.horarioSaidaOrdemServico = horarioSaidaOrdemServico;
	}
	public String getObservacoesOrdemServico() {
		return observacoesOrdemServico;
	}
	public void setObservacoesOrdemServico(String observacoesOrdemServico) {
		this.observacoesOrdemServico = observacoesOrdemServico;
	}
	public float getValorOrdemServico() {
		return valorOrdemServico;
	}
	public void setValorOrdemServico(float valorOrdemServico) {
		this.valorOrdemServico = valorOrdemServico;
	}
	public int getOrcamentoOrdemServico() {
		return orcamentoOrdemServico;
	}
	public void setOrcamentoOrdemServico(int orcamentoOrdemServico) {
		this.orcamentoOrdemServico = orcamentoOrdemServico;
	}
	public String getGarantiaOrdemServico() {
		return garantiaOrdemServico;
	}
	public void setGarantiaOrdemServico(String garantiaOrdemServico) {
		this.garantiaOrdemServico = garantiaOrdemServico;
	}
	public float getValorPecaOrdemServico() {
		return valorPecaOrdemServico;
	}
	public void setValorPecaOrdemServico(float valorPecaOrdemServico) {
		this.valorPecaOrdemServico = valorPecaOrdemServico;
	}
	public float getValorTotaOrdemServico() {
		return valorTotaOrdemServico;
	}
	public void setValorTotaOrdemServico(float valorTotaOrdemServico) {
		this.valorTotaOrdemServico = valorTotaOrdemServico;
	}
	
	

}
