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
