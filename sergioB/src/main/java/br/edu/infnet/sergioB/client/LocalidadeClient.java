package br.edu.infnet.sergioB.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sergioB.model.domain.Estado;
import br.edu.infnet.sergioB.model.domain.Municipio;

//https://servicodados.ibge.gov.br/api/v1/localidades/estados
//https://servicodados.ibge.gov.br/api/v1/localidades/estados/33/municipios
@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades/", name ="localidadeClient")
public interface LocalidadeClient {

	@GetMapping(value = "/estados")
	Collection<Estado> findEstado();
	
	@GetMapping(value = "/{uf}/estados")
	Collection<Municipio> findMunicipio(@PathVariable Integer uf); 
}
