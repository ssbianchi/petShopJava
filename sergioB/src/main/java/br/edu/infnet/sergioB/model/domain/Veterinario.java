package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TVeterinario")
public class Veterinario extends Servico {
	private String nome;
	private int numCrv;
	private String especialidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumCrv() {
		return numCrv;
	}

	public void setNumCrv(int numCrv) {
		this.numCrv = numCrv;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
