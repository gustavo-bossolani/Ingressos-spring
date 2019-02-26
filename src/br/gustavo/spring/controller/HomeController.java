package br.gustavo.spring.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Evento;

@Controller
public class HomeController {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String mostrarForm(Model model) {
		
		model.addAttribute("instance", Calendar.getInstance());
		model.addAttribute("eventos", dao.eventoDao().buscaEventosDisponiveis());
		return "home";
	}
	//ORGANIZA POR NOME
	@RequestMapping(value="home/nome", method=RequestMethod.GET)
	public String organizaPorNome(@ModelAttribute("evento") Evento evento, Model model ) {
		
		model.addAttribute("eventos", dao.eventoDao().organizaPorNome());
		return "home";
	}
	//ORGANIZA POR QUANTIDADE
	@RequestMapping(value="home/quantidade")
	public String organizaPorQuantidade(@ModelAttribute("evento") Evento evento, Model model) {
		
		model.addAttribute("eventos", dao.eventoDao().organizaPorCapacidade());
		return "home";
	}
	//ORGANIZA POR DATA
	@RequestMapping(value="home/data", method=RequestMethod.GET)
	public String organizaPorData(@ModelAttribute("evento") Evento evento, Model model ) {
		
		model.addAttribute("eventos", dao.eventoDao().organizaPorData());
		return "home";
	}
	//ORGANIZA POR PREÇO
	@RequestMapping(value="home/preco", method=RequestMethod.GET)
	public String organizaPorPreco(@ModelAttribute("evento") Evento evento, Model model ) {
		
		model.addAttribute("eventos", dao.eventoDao().organizaPorPrecoIngresso());
		return "home";
	}
	
	//EXIBE TODOS OS EVENTOS JÁ CADASTRADOS
	@RequestMapping(value="home/todos", method= RequestMethod.GET)
	public String bscaTodos(@ModelAttribute("evento") Evento evento, Model model) {
		model.addAttribute("eventos",dao.busca(Evento.class));
		return "home";
	}
}
