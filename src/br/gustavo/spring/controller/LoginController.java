package br.gustavo.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Cliente;
import br.gustavo.spring.model.Evento;

@Controller
public class LoginController {

	@Autowired
	private Dao dao;
	
	@RequestMapping("login")
	public String login(HttpSession session) {
		session.setAttribute("falha", false);
		session.setAttribute("registrado", false);
		return "login-form";
	}
	
	@RequestMapping("logar")
	public String logar(Cliente cliente, HttpSession session, Model model) {
		if(dao.clienteDao().verificaSeExiste(cliente)) {
			session.setAttribute("clienteLogado", cliente);
			
			Cliente cliente1 = dao.clienteDao().buscaDados(cliente);
			
			model.addAttribute("clienteLogado", cliente1);
			session.setAttribute("clienteLogado", cliente1);
			
			return "redirect:/home";
		}
		System.out.println(cliente.getEmail() + " " + cliente.getSenha());
		session.setAttribute("falha", true);
		return "redirect:/login";
	}
	
	@RequestMapping("registrar")
	public String registrar(@ModelAttribute("cliente") Cliente cliente, Model model, HttpSession session) {
		
		System.out.println("Email: " + cliente.getEmail() + " Nome: " + cliente.getNome());
		
		if (cliente.getId() != 0 && !dao.clienteDao().verificaSeExiste(cliente)) {
			dao.salva(cliente);
			session.setAttribute("registrado", true);
		}
		return "redirect:/login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	
}
