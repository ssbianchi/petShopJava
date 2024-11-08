package br.edu.infnet.sergioB.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}
