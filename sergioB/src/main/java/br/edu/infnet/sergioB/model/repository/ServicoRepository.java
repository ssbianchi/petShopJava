package br.edu.infnet.sergioB.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Servico;

@Repository
public interface ServicoRepository extends CrudRepository<Servico, Integer> {

	List<Servico> findByDescricaoContaining(String descricao, Sort by);
	
	Iterable<Servico> findAll(Sort by);
	
	List<Servico> findByPrecoBetween(float precoInicial, float precoFinal);
}
