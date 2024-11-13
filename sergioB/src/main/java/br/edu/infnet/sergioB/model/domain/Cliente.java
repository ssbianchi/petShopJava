package br.edu.infnet.sergioB.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TCliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String cpf;
	private String tel;
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Animal> animals;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Cliente() {
		animals = new ArrayList<Animal>();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Cliente {\n")
	      .append("  ID: ").append(id).append(",\n")
	      .append("  Nome: '").append(nome != null ? nome : "N/A").append("',\n")
	      .append("  CPF: ").append(cpf).append(",\n")
	      .append("  Telefone: '").append(tel != null ? tel : "N/A").append("',\n")
	      .append("  Email: '").append(email != null ? email : "N/A").append("',\n")
	      .append("  Endereço: ").append(endereco != null ? endereco : "N/A").append(",\n")
	      .append("  Animais: ").append(animals.isEmpty() ? "Nenhum" : animals.size()).append("\n");

	    if (!animals.isEmpty()) {
	        sb.append("  Lista de Animais:\n");
	        for (Animal animal : animals) {
	            sb.append("    - ").append(animal).append("\n");
	        }
	    }
	    sb.append("}");
	    return sb.toString();
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
