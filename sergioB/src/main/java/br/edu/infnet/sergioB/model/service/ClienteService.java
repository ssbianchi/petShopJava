package br.edu.infnet.sergioB.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.model.domain.Cliente;

@Service
public class ClienteService {

	private Map<Float, Cliente> mapaClientes = new HashMap<Float, Cliente>();
	public void incluir(Cliente cliente) {
		mapaClientes.put(cliente.getCpf(), cliente);
	}
	
	public Collection<Cliente> lerLista(){
		return mapaClientes.values();
	}
}
