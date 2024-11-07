package br.edu.infnet.sergioB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.infnet.sergioB.client.EnderecoClient;
import br.edu.infnet.sergioB.model.controller.EnderecoController;
import br.edu.infnet.sergioB.model.domain.Endereco;

@SpringBootTest
class EnderecoTests {
	@Autowired
	private EnderecoController enderecoController;

	@MockBean
	private EnderecoClient enderecoClient;

	@Test
	public void testBuscarEnderecoComCepValido() {
		String cep = "01001000";
		Endereco mockEndereco = new Endereco();
		mockEndereco.setCep(cep);

		when(enderecoClient.findByCep(cep)).thenReturn(mockEndereco);

		ResponseEntity<Endereco> response = enderecoController.buscarEndereco(cep);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@Test
	public void testBuscarEnderecoComCepInvalido() {
		String cep = "";
		ResponseEntity<Endereco> response = enderecoController.buscarEndereco(cep);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
}
