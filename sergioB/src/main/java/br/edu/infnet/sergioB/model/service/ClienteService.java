package br.edu.infnet.sergioB.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.domain.Endereco;
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
		return (Collection<Cliente>) clienteRepository.findAll();
	}
}
