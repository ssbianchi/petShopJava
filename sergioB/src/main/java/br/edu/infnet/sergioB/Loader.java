package br.edu.infnet.sergioB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.sergioB.client.EnderecoClient;
import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.domain.Endereco;
import br.edu.infnet.sergioB.model.domain.Exame;
import br.edu.infnet.sergioB.model.domain.Veterinario;
import br.edu.infnet.sergioB.model.service.AnimalService;
import br.edu.infnet.sergioB.model.service.ClienteService;
import br.edu.infnet.sergioB.model.service.ServicoService;

@Component
public class Loader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoClient enderecoClient;

	@Autowired
	private AnimalService animalService;

	@Autowired
	private ServicoService servicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/Clientes.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();

		Cliente cliente = null;
		Animal animal = null;

		while (linha != null) {

			String[] campos = linha.split(";");

			switch (campos[0].toUpperCase()) {
			case "C":
				Endereco endereco = enderecoClient.findByCep(campos[5]);
				cliente = new Cliente();

				cliente.setNome(campos[1]);
				cliente.setCpf(Float.parseFloat(campos[2]));
				cliente.setTel(campos[3]);
				cliente.setEmail(campos[4]);
				cliente.setEndereco(endereco);

				clienteService.incluir(cliente);
				break;
			case "A":
				animal = new Animal();

				animal.setNome(campos[1]);
				animal.setRegistroAnimal(campos[2]);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				animal.setDtNascimento(LocalDate.parse(campos[3], formatter));
				animal.setPeso(Float.parseFloat(campos[4]));
				animal.setRaca(campos[5]);
				animal.setDescricao(campos[6]);
				animal.setCliente(cliente);

				animalService.incluir(animal);
				break;
			case "E":
				Exame exame = new Exame();

				exame.setCodigo(Integer.valueOf(campos[1]));
				exame.setDescricao(campos[2]);
				exame.setPreco(Float.parseFloat(campos[3]));
				exame.setEmergencia(Boolean.parseBoolean(campos[4]));
				exame.setNome(campos[5]);
				exame.setCaracteristica(campos[6]);
				exame.setCodlaudo(campos[7]);
				exame.setLaboratorio(campos[8]);
				exame.setAnimal(animal);

				servicoService.incluir(exame);
				break;
			case "V":
				Veterinario vet = new Veterinario();

				vet.setCodigo(Integer.valueOf(campos[1]));
				vet.setDescricao(campos[2]);
				vet.setPreco(Float.parseFloat(campos[3]));
				vet.setEmergencia(Boolean.parseBoolean(campos[4]));
				vet.setNome(campos[5]);
				vet.setNumCrv(Integer.parseInt(campos[6]));
				vet.setEspecialidade(campos[7]);
				vet.setAnimal(animal);

				servicoService.incluir(vet);
				break;
			default:
				break;
			}
			linha = leitura.readLine();
		}

		for (Cliente c : clienteService.lerLista()) {
			System.out.println("Cliente cadastrado com sucesso: " + c);
		}

		//System.out.println("## findByNomeContaining ## " + clienteService.lerPorNome("bianchi"));
	
		leitura.close();
	}
}
