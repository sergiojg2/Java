package crazy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import crazy.model.client.Cliente;
import crazy.service.client.IClientService;

@Controller
@RequestMapping(value="/")
public class ClientController {
	
	@Autowired
	IClientService cs;
	
	
	 
 public IClientService getCs() {
		return cs;
	}



	public void setCs(IClientService cs) {
		this.cs = cs;
	}



public String clientView(Model model){
	
	 Cliente c  = cs.getClientbd("pperez@gmail.com");
	 model.addAttribute("cliente",c);
	 model.addAttribute("saludo","Hola amigos");
	 return "vistacliente";
 }

}
