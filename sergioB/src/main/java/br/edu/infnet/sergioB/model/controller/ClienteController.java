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
import org.springframework.ui.Model;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.service.ClienteService;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	//@Operation(summary = "Recupera todos os clientes existentes.")
	//@ApiResponses(value = {
	//		@ApiResponse(responseCode = "200", description = "Sucesso"),
	//		@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
	//	})
	
	@GetMapping(value = "/lista")
	public Collection<Cliente> lerLista(){
		return clienteService.lerLista();
	}
	
	//@Operation(summary = "Lista os clientes através do nome.")
	@GetMapping(value = "/lista/{nome}")
	public ResponseEntity<List<Cliente>> obterPorNome(@PathVariable String nome){
		
		List<Cliente> clientes = clienteService.lerPorNome(nome);
		
		if(clientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clientes);
		}
		
		return ResponseEntity.ok(clientes);
	}	
	

	@PostMapping(value = "/incluir", consumes = "application/json")
	public ResponseEntity<String> incluir(@RequestBody Cliente cliente) {
	    clienteService.incluir(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	//@Operation(summary = "Exclui um cliente através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(clienteService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_CLIENTE_NOT_FOUND);
	}
	
	//@Operation(summary = "Pega um cliente através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> obterPorId(@PathVariable Integer id) {
		
		Cliente cliente = clienteService.lerPorId(id);
		
		if(cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(cliente);
	}
	
}
