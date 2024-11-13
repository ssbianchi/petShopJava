package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TEndereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

	public Endereco() {

	}
	
	public Endereco(String cep) {
		this();
		this.setCep(cep);
	}

	@Override
	public String toString() {
	    return "Endereco {\n" +
	           "  ID: " + id + ",\n" +
	           "  CEP: '" + (cep != null ? cep : "N/A") + "',\n" +
	           "  Logradouro: '" + (logradouro != null ? logradouro : "N/A") + "',\n" +
	           "  Complemento: '" + (complemento != null ? complemento : "N/A") + "',\n" +
	           "  Bairro: '" + (bairro != null ? bairro : "N/A") + "',\n" +
	           "  Localidade: '" + (localidade != null ? localidade : "N/A") + "',\n" +
	           "  UF: '" + (uf != null ? uf : "N/A") + "'\n" +
	           "}";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
