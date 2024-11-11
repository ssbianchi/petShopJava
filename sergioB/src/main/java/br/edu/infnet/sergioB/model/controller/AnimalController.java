package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.service.AnimalService;

@RestController
public class AnimalController {
	@Autowired
	private AnimalService animalService;

	@GetMapping(value = "/animal/lista")
	public Collection<Animal> lerLista() {
		return animalService.lerLista();
	}

	// @Operation(summary = "Lista os animais através do nome.")
	@GetMapping(value = "/animal/lista/{nome}")
	public ResponseEntity<List<Animal>> obterPorNome(@PathVariable String nome) {

		List<Animal> animais = animalService.lerPorNome(nome);

		if (animais.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(animais);
		}

		return ResponseEntity.ok(animais);
	}
}
