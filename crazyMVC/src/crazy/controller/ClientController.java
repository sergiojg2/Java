package crazy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crazy.model.Client;
import crazy.service.IClientService;

@Controller
@RequestMapping(value = "/")
public class ClientController {
	@Autowired
	IClientService clientService;
	@RequestMapping(value = "/hola", method=RequestMethod.GET)
	public String obtenerCliente(Model model) {
		Client c1 = clientService.getClient("pperez@gmail.com");
		Client c2 = clientService.getClient("pgarcia@hotmail.com");
		//en la vista recuperare cliente1 que sera el c1del controllador
		model.addAttribute("cliente1", c1);
		model.addAttribute("cliente2", c2);
		model.addAttribute("saludo", "Hola que tal");
		//se comunica com el jsp de cliente.jsp
		return "cliente";
	}
	@RequestMapping(value = "/lista", method=RequestMethod.GET)
	public String obtenerClientelista(Model model) {
		
		List<Client> lista = clientService.getListaClients();
		model.addAttribute("lista", lista);
		
	return "listacliente";	
	}
}
