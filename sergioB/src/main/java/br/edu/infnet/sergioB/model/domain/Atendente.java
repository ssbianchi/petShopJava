package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAtendente")
public class Atendente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String cpf;
	private String email;
	private String matricula;

	@Override
	public String toString() {
	    return String.format(
	        "Atendente {\n" +
	        "  ID: %d,\n" +
	        "  Nome: '%s',\n" +
	        "  CPF: '%s',\n" +
	        "  Email: '%s',\n" +
	        "  Matrícula: '%s'\n" +
	        "}",
	        id,
	        nome != null ? nome : "N/A",
	        cpf != null ? cpf : "N/A",
	        email != null ? email : "N/A",
	        matricula != null ? matricula : "N/A"
	    );
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
