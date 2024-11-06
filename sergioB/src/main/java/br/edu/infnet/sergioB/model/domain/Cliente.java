package br.edu.infnet.sergioB.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private float cpf;
	private String tel;
	private String email;
	
	@Transient
	private List<Animal> animals;
	@Transient
	private Endereco endereco;
	
	public Cliente() 
	{
		animals = new ArrayList<Animal>();
	}
	
	@Override
	public String toString() {
		return String.format("[%f] Cliente %s cadastrado com sucesso! Pets: %d, Endereco: $s", 
				cpf,
				nome,
				animals.size(),
				endereco);
		//return "[" + cpf + "] Cliente " + nome + "cadastrado com sucesso!" + animals.size() + endereco.toString();
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

	public float getCpf() {
		return cpf;
	}

	public void setCpf(float cpf) {
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
