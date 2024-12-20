package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Exame;
import br.edu.infnet.sergioB.model.repository.ExameRepository;
import exceptions.ExameNaoEncontradoException;

@Service
public class ExameService {
	@Autowired
	private ExameRepository exameRepository;

	public Exame incluir(Exame exame) {
		return exameRepository.save(exame);
	}

	public Collection<Exame> lerLista() {
		return (Collection<Exame>) exameRepository.findAll();
	}

	public boolean excluir(Integer id) {

		exameRepository.deleteById(id);

		return true;
	}

	public List<Exame> lerPorNome(String nome) {
		return exameRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public long lerQtde() {
		return exameRepository.count();
	}

	public Exame lerPorId(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}

	public Exame alterar(Integer id, float preco) {

		Exame exameExistente = exameRepository.findById(id)
				.orElseThrow(() -> new ExameNaoEncontradoException(Constantes.MSG_SERVICO_NOT_FOUND));

		exameExistente.setPreco(preco);

		return exameRepository.save(exameExistente);
	}
}