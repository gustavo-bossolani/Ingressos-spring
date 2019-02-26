package br.gustavo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.CasaShow;

@Controller
@RequestMapping("casaShow")
public class CasaShowController {
	
	@Autowired
	private Dao dao;
	
	//Este método é chamado assim que a página é chamada
	@RequestMapping(value="", method=RequestMethod.GET)
	public String mostrarForm(Model model) {
		
		model.addAttribute("casaShow", new CasaShow());
		model.addAttribute("casaShows", dao.busca(CasaShow.class));
		
		return "casaShow";
	}
	
	//ADCIONANDO NO BANCO
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processarForm(@ModelAttribute("casaShow") CasaShow casaShow, Model model ) {
		
		if (casaShow.getId() == 0) {
			dao.salva(casaShow);
		}else {
			dao.atualiza(casaShow);
		}
		return "redirect:/casaShow/";
	}
	
	//EDITANDO
	@RequestMapping(value="/edit/{id}")
	public String processarEdicao(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("casaShow", dao.buscaPorID(CasaShow.class, id));
		model.addAttribute("casaShows", dao.busca(CasaShow.class));
		
		return "casaShow";
	}
	
	//REMOVENDO
	@RequestMapping(value="/remove/{id}")
	public String processarDeletar(@PathVariable("id") int id) {
		CasaShow casaShow = dao.buscaPorID(CasaShow.class, id);
		dao.deleta(casaShow);
		return "redirect:/casaShow/";
	}

}
