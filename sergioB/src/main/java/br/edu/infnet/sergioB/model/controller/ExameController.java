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
import br.edu.infnet.sergioB.model.domain.Exame;
import br.edu.infnet.sergioB.model.service.ExameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	private ExameService exameService;

	@Operation(summary = "Recupera todos os veterinarios existentes.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista")
	public Collection<Exame> lerLista() {
		return exameService.lerLista();
	}

	@Operation(summary = "Lista os exames através do nome.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista/{nome}")
	public ResponseEntity<List<Exame>> obterPorNome(@PathVariable String nome) {

		List<Exame> exames = exameService.lerPorNome(nome);

		if (exames.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exames);
		}

		return ResponseEntity.ok(exames);
	}

	@Operation(summary = "Inclui um exame.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Exame exame) {
		exameService.incluir(exame);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}

	@Operation(summary = "Exclui um exame através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if (exameService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLIENTE_NOT_FOUND);
	}

	@Operation(summary = "Pega um exame através do ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Exame> obterPorId(@PathVariable Integer id) {

		Exame exame = exameService.lerPorId(id);

		if (exame == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(exame);
	}
}