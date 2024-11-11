package br.edu.infnet.sergioB.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Atendente;

@Repository
public interface AtendenteRepository extends CrudRepository<Atendente, Integer> {

	List<Atendente> findByNomeContaining(String nome, Sort by);
	
	Iterable<Atendente> findAll(Sort by);
}
