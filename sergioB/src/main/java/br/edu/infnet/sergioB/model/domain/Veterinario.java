package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TVeterinario")
public class Veterinario extends Servico {
	private String nome;
	private int numCrv;
	private String especialidade;

	@Override
	public String toString() {
	    return "Veterinario {\n" +
	           "  Nome: '" + (nome != null ? nome : "N/A") + "'\n" +
	           "  Número CRV: " + numCrv + "\n" +
	           "  Especialidade: '" + (especialidade != null ? especialidade : "N/A") + "'\n" +
	           "  Descrição: '" + getDescricao() + "'\n" +
	           "  Código: " + getCodigo() + "\n" +
	           "  Preço: R$" + getPreco() + "\n" +
	           "  Emergência: " + (isEmergencia() ? "Sim" : "Não") + "\n" +
	           "  Animal: " + (getAnimal() != null ? getAnimal().getNome() : "N/A") + "\n" +
	           "}";
	}


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
