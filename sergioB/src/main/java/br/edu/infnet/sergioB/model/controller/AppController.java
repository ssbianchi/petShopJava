package br.edu.infnet.sergioB.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import br.edu.infnet.sergioB.model.service.AnimalService;
import br.edu.infnet.sergioB.model.service.ClienteService;
import br.edu.infnet.sergioB.model.service.ExameService;
import br.edu.infnet.sergioB.model.service.ServicoService;
import br.edu.infnet.sergioB.model.service.VeterinarioService;

@Controller
public class AppController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private VeterinarioService veterinarioService;
	@Autowired
	private ExameService exameService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeCliente", clienteService.lerQtde());
		model.addAttribute("qtdeAnimal", animalService.lerQtde());
		model.addAttribute("qtdeServico", servicoService.lerQtde());
		model.addAttribute("qtdeVeterinario", veterinarioService.lerQtde());
		model.addAttribute("qtdeExame", exameService.lerQtde());

		return "home";
	}

	@GetMapping(value = "/cliente/listagem")
	public String clienteLista(Model model) {

		model.addAttribute("titulo", "Listagem de clientes");
		model.addAttribute("listagem", clienteService.lerLista());

		return telaHome(model);
	}

	@GetMapping(value = "/animal/listagem")
	public String animalLista(Model model) {

		model.addAttribute("titulo", "Listagem de animais");
		model.addAttribute("listagem", animalService.lerLista());

		return telaHome(model);
	}

	@GetMapping(value = "/servico/listagem")
	public String servicoLista(Model model) {

		model.addAttribute("titulo", "Listagem de servicos");
		model.addAttribute("listagem", servicoService.lerLista());

		return telaHome(model);
	}

	@GetMapping(value = "/veterinario/listagem")
	public String veterinarioLista(Model model) {

		model.addAttribute("titulo", "Listagem de servicos veterinários");
		model.addAttribute("listagem", veterinarioService.lerLista());

		return telaHome(model);
	}

	@GetMapping(value = "/exame/listagem")
	public String exameLista(Model model) {

		model.addAttribute("titulo", "Listagem de servicos exames");
		model.addAttribute("listagem", exameService.lerLista());

		return telaHome(model);
	}
}
