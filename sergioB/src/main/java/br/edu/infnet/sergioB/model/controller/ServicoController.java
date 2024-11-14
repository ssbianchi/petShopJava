package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Servico;
import br.edu.infnet.sergioB.model.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	@Autowired
	private ServicoService servicoService;

	@Operation(summary = "Lista todos os servicos existentes.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/lista")
	public Collection<Servico> lerLista() {
		return servicoService.lerLista();
	}

	@Operation(summary = "Lista todos os servicos existentes filtrando pelo preco maximo e minimo.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/filtrarPorPreco/{min}/{max}")
	public ResponseEntity<List<Servico>> obterListaPorPreco(@RequestParam float min, @RequestParam float max) {
		if (min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		List<Servico> produtos = servicoService.listaListaPorPreco(min, max);

		if (produtos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(produtos);
		}

		return ResponseEntity.ok(produtos);
	}

	@Operation(summary = "Inlcui servico.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Servico servico) {
		servicoService.incluir(servico);

		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}

	@Operation(summary = "Exlui servico atraves Id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@DeleteMapping(value = "/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		servicoService.excluir(id);

		return "Exclusão realizada com sucesso.";
	}

	@Operation(summary = "Lista servicos por Id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@GetMapping(value = "/{id}")
	public Servico obterPorId(@PathVariable Integer id) {
		return servicoService.lerPorId(id);
	}

	@Operation(summary = "Altera o preco do servico atraves do id.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema") })
	@PatchMapping(value = "/alterar")
	public ResponseEntity<Servico> alterar(@RequestParam Integer id, @RequestParam float preco) {

		Servico produtoAtualizado = servicoService.alterar(id, preco);

		return ResponseEntity.ok(produtoAtualizado);
	}
}
