package br.edu.infnet.sergioB.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sergioB.model.domain.Veterinario;

@Repository
public interface VeterinarioRepository extends CrudRepository<Veterinario, Integer> {

	List<Veterinario> findByNomeContaining(String nome, Sort by);

	Iterable<Veterinario> findAll(Sort by);
}