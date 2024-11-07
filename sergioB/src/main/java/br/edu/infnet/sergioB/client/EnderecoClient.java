package br.edu.infnet.sergioB.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.sergioB.model.domain.Endereco;

//https://viacep.com.br/ws/01001000/json
@FeignClient(url = "https://viacep.com.br/ws", name ="enderecoClient")
public interface EnderecoClient {
	
	@GetMapping(value = "/{cep}/json")
	Endereco findByCep(@PathVariable String cep);

}
