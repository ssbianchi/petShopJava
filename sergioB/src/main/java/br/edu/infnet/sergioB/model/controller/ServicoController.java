package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.model.domain.Servico;
import br.edu.infnet.sergioB.model.service.ServicoService;

@RestController
public class ServicoController {
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping(value = "/lista/servico")
	public Collection<Servico> lerLista(){
		return servicoService.lerLista();
	}
}
