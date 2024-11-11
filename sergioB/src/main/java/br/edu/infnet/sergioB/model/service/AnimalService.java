package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.repository.AnimalRepository;

@Service
public class AnimalService {
	@Autowired
	private AnimalRepository animalRepository;

	public Animal incluir(Animal animal) {
		return animalRepository.save(animal);
	}

	public Collection<Animal> lerLista() {
		return (Collection<Animal>) animalRepository.findAll();
	}

	public boolean excluir(Integer id) {

		animalRepository.deleteById(id);

		return true;
	}

	public List<Animal> lerPorNome(String nome) {
		return animalRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public long lerQtde() {
		return animalRepository.count();
	}

	public Animal lerPorId(Integer id) {
		return animalRepository.findById(id).orElse(null);
	}
}
