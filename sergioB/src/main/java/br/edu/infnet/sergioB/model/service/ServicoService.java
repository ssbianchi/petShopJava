package br.edu.infnet.sergioB.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Servico;
import br.edu.infnet.sergioB.model.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public Servico incluir(Servico servico) {
		return servicoRepository.save(servico);
	}

	public Collection<Servico> lerLista() {
		return (Collection<Servico>) servicoRepository.findAll();
	}
}
