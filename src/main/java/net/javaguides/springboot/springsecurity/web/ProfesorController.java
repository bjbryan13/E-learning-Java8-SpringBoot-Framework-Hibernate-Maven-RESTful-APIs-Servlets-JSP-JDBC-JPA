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

import net.javaguides.springboot.springsecurity.model.Profesor;
import net.javaguides.springboot.springsecurity.service.ProfesorService;

@Controller
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/Profesor")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nombre", "asc", model);		
	}
	
	@GetMapping("/showNewProfesorForm")
	public String showNewEmpresaaForm(Model model) {
		// create model attribute to bind form data
		 
		Profesor personaa = new Profesor();
		model.addAttribute("personaa", personaa);
		return "new_Profesor";
	}
	@PostMapping("/saveProfesor")
	public String saveEmpresaa(@ModelAttribute("personaa") Profesor personaa) {
		// save employee to database

		profesorService.saveProfesor(personaa);
		return "redirect:/Profesor";
	}
	@GetMapping("/showFormForProfesorUpdate/{id}")
	public String showFormForEmpresaUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		
		// get employee from the service
		Profesor personaa = profesorService.getProfesorId(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("personaa", personaa);
		return "update_Profesor";
	}
	@GetMapping("/deleteProfesor{id}")
	public String deletePersonaa(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.profesorService.deleteProfesorById(id);
		return "redirect:/Profesor";
	}
	@GetMapping("/pageProfesor/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5000;
		
		Page<Profesor> page = profesorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Profesor> listPersonaa = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listPersonaas", listPersonaa);
		return "index_profesor";
	}
}
