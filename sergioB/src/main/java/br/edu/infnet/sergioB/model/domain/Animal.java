package br.edu.infnet.sergioB.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAnimal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String registroAnimal;
	private LocalDate dtNascimento;
	private Float peso;
	private String descricao;
	private String raca;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Cliente cliente;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Servico> servicos;

	public Animal() {
		servicos = new ArrayList<Servico>();
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Animal {\n")
	      .append("  ID: ").append(id).append("\n")
	      .append("  Nome: '").append(nome != null ? nome : "N/A").append("'\n")
	      .append("  Registro: '").append(registroAnimal != null ? registroAnimal : "N/A").append("'\n")
	      .append("  Data de Nascimento: ").append(dtNascimento != null ? dtNascimento : "N/A").append("\n")
	      .append("  Peso: ").append(peso != null ? String.format("%.2f kg", peso) : "N/A").append("\n")
	      .append("  Raça: '").append(raca != null ? raca : "N/A").append("'\n")
	      .append("  Descrição: '").append(descricao != null ? descricao : "N/A").append("'\n")
	      .append("  Cliente: ").append(cliente != null ? cliente.getNome() : "Sem cliente associado").append("\n")
	      .append("  Serviços: ").append(servicos.isEmpty() ? "Nenhum serviço" : servicos.size()).append("\n");

	    if (!servicos.isEmpty()) {
	        sb.append("  Lista de Serviços:\n");
	        for (Servico servico : servicos) {
	            sb.append("    - ").append(servico).append("\n");
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

	public String getRegistroAnimal() {
		return registroAnimal;
	}

	public void setRegistroAnimal(String registroAnimal) {
		this.registroAnimal = registroAnimal;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
