package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Veterinario;
import br.edu.infnet.sergioB.model.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	@Autowired
	private VeterinarioRepository veterinarioRepository;

	public Veterinario incluir(Veterinario veterinario) {
		return veterinarioRepository.save(veterinario);
	}

	public Collection<Veterinario> lerLista() {
		return (Collection<Veterinario>) veterinarioRepository.findAll();
	}

	public boolean excluir(Integer id) {

		veterinarioRepository.deleteById(id);

		return true;
	}

	public List<Veterinario> lerPorNome(String nome) {
		return veterinarioRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public long lerQtde() {
		return veterinarioRepository.count();
	}

	public Veterinario lerPorId(Integer id) {
		return veterinarioRepository.findById(id).orElse(null);
	}
}
