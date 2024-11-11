package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public boolean excluir(Integer id) {

		atendenteRepository.deleteById(id);

		return true;
	}

	public List<Atendente> lerPorNome(String nome) {
		return atendenteRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public long lerQtde() {
		return atendenteRepository.count();
	}

	public Atendente lerPorId(Integer id) {
		return atendenteRepository.findById(id).orElse(null);
	}
}

