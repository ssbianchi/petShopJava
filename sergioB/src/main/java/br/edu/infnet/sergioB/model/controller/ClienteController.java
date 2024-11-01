package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/lista/cliente")
	public Collection<Cliente> lerLista(){
		return clienteService.lerLista();
	}
}
