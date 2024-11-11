package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public boolean excluir(Integer id) {

		servicoRepository.deleteById(id);

		return true;
	}

	public List<Servico> lerPorNome(String descricao) {
		return servicoRepository.findByDescricaoContaining(descricao, Sort.by(Sort.Order.asc("descricao")));
	}

	public long lerQtde() {
		return servicoRepository.count();
	}

	public Servico lerPorId(Integer id) {
		return servicoRepository.findById(id).orElse(null);
	}
}
