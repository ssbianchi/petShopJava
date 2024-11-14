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
import br.edu.infnet.sergioB.model.domain.Atendente;
import br.edu.infnet.sergioB.model.service.AtendenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {
	@Autowired
	private AtendenteService atendenteService;

	@Operation(summary = "Lista todos os atendentes.")
	@GetMapping(value = "/lista")
	public Collection<Atendente> lerLista() {
		return atendenteService.lerLista();
	}

	@Operation(summary = "Lista atendente por nome.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista/{nome}")
	public ResponseEntity<List<Atendente>> obterPorNome(@PathVariable String nome) {

		List<Atendente> atendentes = atendenteService.lerPorNome(nome);

		if (atendentes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(atendentes);
		}

		return ResponseEntity.ok(atendentes);
	}

	@Operation(summary = "Inclui atendente.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Atendente atendente) {
		atendenteService.incluir(atendente);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}

	@Operation(summary = "Exclui um atendente através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if (atendenteService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLIENTE_NOT_FOUND);
	}

	@Operation(summary = "Pega um atendente através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendente> obterPorId(@PathVariable Integer id) {

		Atendente atendente = atendenteService.lerPorId(id);

		if (atendente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(atendente);
	}
}
