package br.edu.infnet.sergioB.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.sergioB.client.EnderecoClient;
import br.edu.infnet.sergioB.client.LocalidadeClient;
import br.edu.infnet.sergioB.model.domain.Endereco;
import br.edu.infnet.sergioB.model.domain.Estado;
import br.edu.infnet.sergioB.model.domain.Municipio;

@Service
public class LocalizacaoService {

	@Autowired
	private EnderecoClient enderecoClient;
	@Autowired
	private LocalidadeClient localidadeClient;

	public Endereco findByCep(String cep) {
		return enderecoClient.findByCep(cep);
	}

	public Collection<Estado> findEstados() {
		return localidadeClient.findEstado();
	}

	public Collection<Municipio> findMunicipioByUf(Integer uf) {
		return localidadeClient.findMunicipio(uf);

	}

}
