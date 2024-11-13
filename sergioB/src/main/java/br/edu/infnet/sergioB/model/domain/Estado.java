package br.edu.infnet.sergioB.model.domain;

public class Estado {
	private Integer id;
	private String sigla;
	private String nome;

	@Override
	public String toString() {
	    return "Estado {\n" +
	           "  ID: " + (id != null ? id : "N/A") + ",\n" +
	           "  Sigla: '" + (sigla != null ? sigla : "N/A") + "',\n" +
	           "  Nome: '" + (nome != null ? nome : "N/A") + "'\n" +
	           "}";
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
