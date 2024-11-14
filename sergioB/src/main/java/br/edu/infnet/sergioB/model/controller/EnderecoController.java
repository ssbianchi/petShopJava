package br.edu.infnet.sergioB.model.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.sergioB.client.EnderecoClient;
import br.edu.infnet.sergioB.model.domain.Endereco;
import feign.FeignException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoClient enderecoClient;

    public EnderecoController(EnderecoClient enderecoClient) {
        this.enderecoClient = enderecoClient;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable String cep) {
        if (cep == null || cep.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        
        try {
            Endereco endereco = enderecoClient.findByCep(cep);
            return ResponseEntity.ok(endereco);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }
}
