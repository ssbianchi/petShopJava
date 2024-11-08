package br.edu.infnet.sergioB.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Atendente;
import br.edu.infnet.sergioB.model.repository.AtendenteRepository;

@Service
public class AtendenteService {
	@Autowired
	private AtendenteRepository atendenteRepository;
	
	public Atendente incluir (Atendente atendente) {
		return atendenteRepository.save(atendente);
	}
	
	public Collection<Atendente> lerLista(){
		return (Collection<Atendente>) atendenteRepository.findAll();
	}
}

