package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TExame")
public class Exame extends Servico {
	private String nome;
	private String Caracteristica;
	private String codlaudo;
	private String laboratorio;

	@Override
	public String toString() {
	    return "Exame {\n" +
	           "  Nome: '" + (nome != null ? nome : "N/A") + "'\n" +
	           "  Característica: '" + (Caracteristica != null ? Caracteristica : "N/A") + "'\n" +
	           "  Código do Laudo: '" + (codlaudo != null ? codlaudo : "N/A") + "'\n" +
	           "  Laboratório: '" + (laboratorio != null ? laboratorio : "N/A") + "'\n" +
	           "}";
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaracteristica() {
		return Caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		Caracteristica = caracteristica;
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
