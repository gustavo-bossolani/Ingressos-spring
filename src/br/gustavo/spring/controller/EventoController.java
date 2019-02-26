package br.gustavo.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spring.dto.EventoDTO;
import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.CasaShow;
import br.gustavo.spring.model.Evento;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	private Dao dao;
	
	//Variável auxiliar para edição do evento na mesma data
	private Evento eventoAlterado = new Evento();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showForm(Model model) {
		
		model.addAttribute("evento", new Evento());
		model.addAttribute("eventos", dao.busca(Evento.class));
		model.addAttribute("casaShows", dao.busca(CasaShow.class));
		model.addAttribute("verificaEvento", false);
		
		return "evento";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST) //precisamos mudar o paramentro de Evento para EventoDTO
	public String processForm(@ModelAttribute("evento") EventoDTO eventoDTO, Model model, HttpServletRequest request, int id) {
		
		//Realizando a conversão do evento DTO para um objeto completo que será adcionado para o Banco
		Evento evento = eventoDTO.preencherEvento(dao);
		
		
		//Se o evento existe = deu ruim
		//Se o evento não existe = deu bom
//		if(eventoDTO.eventoExiste(dao, evento)) {
//			System.err.println("Deu ruim meu bom este Evento ja existe");
//			model.addAttribute("verificaEvento", true);
//			
//		}else {
//			if (evento.getId() == 0)
//				dao.salva(evento);
//			else
//				dao.atualiza(evento);
//		}
		if(evento.getId() == 0) {
			if(dao.eventoDao().verificaDisponibilidade(evento)) {
				dao.salva(evento);
			}else {
				System.out.println("Já existe evento na  mesma casa de Show e Data");
			}
			
			//se data e casa show for dele mesmo = true / se não = verifica no banco se tem alguem com a data e casa - se sim = nao atualiza - se não = atualiza
		}else {
			//permitindo atualização para eventos que não queiram mudar de data
			if(evento.getData() == eventoAlterado.getData() && evento.getCasaShow() == eventoAlterado.getCasaShow()) {
				dao.atualiza(evento);
			}else {
				if(dao.eventoDao().verificaDisponibilidade(evento)) {
					dao.atualiza(evento);
				}else {
					System.out.println("Já existe evento na  mesma casa de Show e Data");
				}
				
			}
		}
		
		return "redirect:/evento/";
	}

	//REMOVER
	@RequestMapping(value = "/edit/{id}")
	public String processEdit(@PathVariable("id") int id, Model model) {

		model.addAttribute("casaShows", dao.busca(CasaShow.class));
		model.addAttribute("evento", dao.buscaPorID(Evento.class, id));
		model.addAttribute("eventos", dao.busca(Evento.class));
		eventoAlterado = dao.buscaPorID(Evento.class, id);

		return "evento";
	}

	//EDITAR
	@RequestMapping(value = "/remove/{id}")
	public String processDelete(@PathVariable("id") int id) {

		Evento s = dao.buscaPorID(Evento.class, id);

		dao.deleta(s);

		return "redirect:/evento/";
	}

}
