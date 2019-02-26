package br.gustavo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.gustavo.spring.dao.Dao;
import br.gustavo.spring.model.Student;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private Dao dao;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String showForm(Model model) {
		
		model.addAttribute("student", new Student());
		model.addAttribute("students", dao.busca(Student.class));
		
		return "student";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processForm(@ModelAttribute("student") Student student, Model model) {
		
		if(student.getId() == 0)
			dao.salva(student);
		else
			dao.atualiza(student);
		
		
		return "redirect:/student/";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String processEdit(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("student", dao.buscaPorID(Student.class, id));
		model.addAttribute("students", dao.busca(Student.class));
		
		return "student";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String processDelete(@PathVariable("id") int id) {
		
		Student s = dao.buscaPorID(Student.class, id);
		
		dao.deleta(s);
		
		return "redirect:/student/";
	}

}
