package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	@Autowired
	private AnimalService animalService;

	@GetMapping(value = "/lista")
	public Collection<Animal> lerLista() {
		return animalService.lerLista();
	}

	// @Operation(summary = "Lista os animais através do nome.")
	@GetMapping(value = "/lista/{nome}")
	public ResponseEntity<List<Animal>> obterPorNome(@PathVariable String nome) {

		List<Animal> animais = animalService.lerPorNome(nome);

		if (animais.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(animais);
		}

		return ResponseEntity.ok(animais);
	}

	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Animal animal) {
		animalService.incluir(animal);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}

	// @Operation(summary = "Exclui um animal através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if (animalService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLIENTE_NOT_FOUND);
	}

	// @Operation(summary = "Pega um animal através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Animal> obterPorId(@PathVariable Integer id) {

		Animal animal = animalService.lerPorId(id);

		if (animal == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(animal);
	}
}
