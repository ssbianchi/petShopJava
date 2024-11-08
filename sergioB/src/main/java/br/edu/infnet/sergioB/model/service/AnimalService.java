package br.edu.infnet.sergioB.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
}
