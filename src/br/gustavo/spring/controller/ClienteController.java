package br.gustavo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Cliente;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String mostrarForm(Model model) {
		
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("clientes", dao.busca(Cliente.class));
		
		return "cliente";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processarForm(@ModelAttribute("cliente") Cliente cliente, Model model ) {
		
		if (cliente.getId() == 0) {
			dao.salva(cliente);
		}else {
			dao.atualiza(cliente);
		}
		return "redirect:/cliente/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String processarEdicao(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("cliente", dao.buscaPorID(Cliente.class, id));
		model.addAttribute("clientes", dao.busca(Cliente.class));
		
		return "cliente";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String processarDeletar(@PathVariable("id") int id) {
		Cliente cliente = dao.buscaPorID(Cliente.class, id);
		dao.deleta(cliente);
		return "redirect:/cliente/";
	}

}
