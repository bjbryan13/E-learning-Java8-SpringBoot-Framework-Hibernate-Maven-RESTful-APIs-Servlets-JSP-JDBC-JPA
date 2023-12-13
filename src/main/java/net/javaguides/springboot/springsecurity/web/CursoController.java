package net.javaguides.springboot.springsecurity.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.springsecurity.model.Curso;
import net.javaguides.springboot.springsecurity.service.CursoService;

@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/Curso")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nombre", "asc", model);		
	}

	@GetMapping("/showNeCursoForm")
	public String showNewEmpresaaForm(Model model) {
		// create model attribute to bind form data
		 
		Curso personaa = new Curso();
		model.addAttribute("personaa", personaa);
		return "new_Curso";
	}
	

	@PostMapping("/saveCurso")
	public String saveEmpresaa(@ModelAttribute("personaa") Curso personaa) {
		// save employee to database

		cursoService.saveCurso(personaa);
		return "redirect:/Curso";
	}
	@GetMapping("/showFormForCursoUpdate/{id}")
	public String showFormForEmpresaUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		
		// get employee from the service
		Curso personaa = cursoService.getCursoyId(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("personaa", personaa);
		return "update_Curso";
	}
	@GetMapping("/deleteCurso/{id}")
	public String deletePersonaa(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.cursoService.deleteCursoyId(id);
		return "redirect:/Curso";
	}
	@GetMapping("/pageCurso/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5000;
		
		Page<Curso> page = cursoService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Curso> listPersonaa = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listPersonaas", listPersonaa);
		return "index_curso";
	}
	
}
