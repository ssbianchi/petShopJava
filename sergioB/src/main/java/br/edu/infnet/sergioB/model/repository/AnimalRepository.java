package br.edu.infnet.sergioB.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

	List<Animal> findByNomeContaining(String nome, Sort by);

	Iterable<Animal> findAll(Sort by);
}
