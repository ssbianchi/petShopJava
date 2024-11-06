package br.edu.infnet.sergioB;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.sergioB.model.domain.Animal;
import br.edu.infnet.sergioB.model.domain.Cliente;
import br.edu.infnet.sergioB.model.domain.Endereco;
import br.edu.infnet.sergioB.model.repository.ClienteRepository;
import br.edu.infnet.sergioB.model.service.ClienteService;

@Component
public class Loader implements ApplicationRunner{

	//private Map<Float, Cliente> mapaClientes = new HashMap<Float, Cliente>(); 
	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
				
		//System.out.println("Hello World!!!");
		FileReader file =  new FileReader("files/Clientes.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		Cliente cliente = null;
		
		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch(campos[0].toUpperCase()) 
			{
			case "C":
				//cliente = new Cliente();
				
				Endereco endereco = new Endereco();
				endereco.setCep(campos[5]);
				
				cliente = new Cliente();
				cliente.setNome(campos[1]);
				cliente.setCpf(Float.parseFloat(campos[2]));
				cliente.setTel(campos[3]);
				cliente.setEmail(campos[4]);
				
				cliente.setEndereco(endereco);
								
				//mapaClientes.put(cliente.getCpf(), cliente);
				
				clienteService.incluir(cliente);
				
				break;
			case "A":
				Animal animal = new Animal();
				animal.setNome(campos[1]);
				
				cliente.getAnimals().add(animal);
				break;
			default:
				break;
			}
			
			//System.out.println(linha);
			
			linha = leitura.readLine();
		}
		
		//for(Cliente c: mapaClientes.values()) {
		for(Cliente c: clienteService.lerLista()) {
			System.out.println("Cliente cadastrado com sucesso: " + c);
		}
		
		leitura.close();
	}
}
