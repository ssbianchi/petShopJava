package br.edu.infnet.sergioB.model.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.model.domain.Atendente;
import br.edu.infnet.sergioB.model.service.AtendenteService;

@RestController
public class AtendenteController {
	@Autowired
	private AtendenteService atendenteService;
	
	@GetMapping(value = "/atendente/lista")
	public Collection<Atendente> lerLista(){
		return atendenteService.lerLista();
	}
}
