package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private Map<Float, Cliente> mapaClientes = new HashMap<Float, Cliente>();
	public void incluir(Cliente cliente) {
		mapaClientes.put(cliente.getCpf(), cliente);
		
		clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> lerLista(){
		return mapaClientes.values();
	}
}
