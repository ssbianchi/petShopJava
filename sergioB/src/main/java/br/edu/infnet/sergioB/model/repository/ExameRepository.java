package br.edu.infnet.sergioB.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer> {

	List<Exame> findByNomeContaining(String nome, Sort by);

	Iterable<Exame> findAll(Sort by);
}