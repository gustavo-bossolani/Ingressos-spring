package br.gustavo.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Cliente;
import br.gustavo.spring.model.Venda;

@Controller
public class HistoricoController {

	@Autowired
	private Dao dao;
	
	@RequestMapping("historico")
	public String venda(Model model, HttpSession session) {
		
		Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
		model.addAttribute("vendas", dao.vendaDao().buscaVendas(cliente));
		return "historico";
	}
	
//
//	@RequestMapping("comprar")
//	public String comprar(Model model, Evento evento) {
//		Evento eventoVendido = dao.buscaPorID(Evento.class, evento.getId());
//		model.addAttribute("evento_vendido",eventoVendido);
//		return "venda";
//	}
//	
//	@RequestMapping("processar")
//	public String processarCompra(int quantidade, int eventoId, int clienteId, HttpSession session) {
//		
//		Evento evento = dao.buscaPorID(Evento.class, eventoId);
//		Cliente cliente = dao.buscaPorID(Cliente.class, clienteId);
//		Venda venda = new Venda();
//		
//		
//		if(quantidade <= evento.getCapacidade()) {
//			evento.setCapacidade(evento.getCapacidade() - quantidade);
//			venda.setEvento(evento);
//			venda.setCliente(cliente);
//			double total = evento.getIngressoUnitario().multiply(new BigDecimal(quantidade)).doubleValue();
//			venda.setTotal(total);
//			
//			dao.salva(venda);
//			dao.atualiza(evento);
//		}
//		return "redirect:home";
//	}
	
}
