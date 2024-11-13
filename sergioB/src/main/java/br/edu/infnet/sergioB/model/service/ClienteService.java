package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.Constantes;
import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.domain.Endereco;
import br.edu.infnet.sergioB.model.repository.AnimalRepository;
import br.edu.infnet.sergioB.model.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private LocalizacaoService localizacaoService;

	public Cliente incluir(Cliente cliente) {

		String cep = cliente.getEndereco().getCep();
		Endereco endereco = localizacaoService.findByCep(cep);

		cliente.setEndereco(endereco);

		return clienteRepository.save(cliente);
	}

	public Collection<Cliente> lerLista() {
		return (Collection<Cliente>) clienteRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}

	public boolean excluir(Integer id) {

		clienteRepository.deleteById(id);

		return true;
	}

	public List<Cliente> lerPorNome(String nome) {
		return clienteRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public long lerQtde() {
		return clienteRepository.count();
	}

	public Cliente lerPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	/*public Animal alterar(Integer id, float peso) {
		
		Animal animalExistente = AnimalRepository.findById(id).orElseThrow(() -> 
			new AnimalNaoEncontradoException(Constantes.MSG_ANIMAL_NOT_FOUND));
		
		animalExistente.setPeso(peso);
		
		return AnimalRepository.save(animalExistente);
	}
	*/
}
