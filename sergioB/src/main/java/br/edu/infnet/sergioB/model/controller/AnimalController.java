package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.service.AnimalService;

@RestController
public class AnimalController {
	@Autowired
	private AnimalService animalService;
	
	@GetMapping(value = "/lista/animal")
	public Collection<Animal> lerLista(){
		return animalService.lerLista();
	}
}
