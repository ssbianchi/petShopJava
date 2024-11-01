package br.edu.infnet.sergioB.model.domain;

public class Exame extends Servico{
	private String descricao;
	private String codlaudo;
	private String laboratorio;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodlaudo() {
		return codlaudo;
	}
	public void setCodlaudo(String codlaudo) {
		this.codlaudo = codlaudo;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
}
