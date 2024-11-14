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
import br.edu.infnet.sergioB.model.domain.Veterinario;
import br.edu.infnet.sergioB.model.service.VeterinarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

	@Autowired
	private VeterinarioService veterinarioService;

	@Operation(summary = "Lista todos os veterinarios.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista")
	public Collection<Veterinario> lerLista() {
		return veterinarioService.lerLista();
	}

	@Operation(summary = "Lista os veterinarios através do nome.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista/{nome}")
	public ResponseEntity<List<Veterinario>> obterPorNome(@PathVariable String nome) {

		List<Veterinario> veterinarios = veterinarioService.lerPorNome(nome);

		if (veterinarios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veterinarios);
		}

		return ResponseEntity.ok(veterinarios);
	}

	@Operation(summary = "Incluir veterinario.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Veterinario veterinario) {
		veterinarioService.incluir(veterinario);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}

	@Operation(summary = "Exclui um veterinario através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if (veterinarioService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLIENTE_NOT_FOUND);
	}

	@Operation(summary = "Pega um veterinario através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veterinario> obterPorId(@PathVariable Integer id) {

		Veterinario veterinario = veterinarioService.lerPorId(id);

		if (veterinario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(veterinario);
	}
}
