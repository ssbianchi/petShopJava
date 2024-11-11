package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Servico;
import br.edu.infnet.sergioB.model.repository.ServicoRepository;
import exceptions.ServicoNaoEncontradoException;

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

	public List<Servico> listaListaPorPreco(float precoInicial, float precoFinal) {
		return servicoRepository.findByPrecoBetween(precoInicial, precoFinal);
	}

	public Servico alterar(Integer id, float preco) {

		Servico servicoExistente = servicoRepository.findById(id)
				.orElseThrow(() -> new ServicoNaoEncontradoException(Constantes.MSG_SERVICO_NOT_FOUND));

		servicoExistente.setPreco(preco);

		return servicoRepository.save(servicoExistente);
	}
}
