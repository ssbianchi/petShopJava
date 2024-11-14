package br.edu.infnet.sergioB.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TServico")
@Inheritance(strategy = InheritanceType.JOINED)
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descricao;
	private int codigo;
	private float preco;
	private boolean emergencia;

	public Servico() {
	}

	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	@Override
	public String toString() {
		return "Servico {\n" + "  ID: " + id + "\n" + "  Descrição: '" + (descricao != null ? descricao : "N/A") + "'\n"
				+ "  Código: " + codigo + "\n" + "  Preço: R$" + preco + "\n" + "  Emergência: "
				+ (emergencia ? "Sim" : "Não") + "\n" + "  Animal: " + (animal != null ? animal.getNome() : "N/A")
				+ "\n" + "}";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
