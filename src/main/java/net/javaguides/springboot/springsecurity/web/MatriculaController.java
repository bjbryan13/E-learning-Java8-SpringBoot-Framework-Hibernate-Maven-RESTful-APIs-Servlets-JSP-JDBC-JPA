package net.javaguides.springboot.springsecurity.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.springsecurity.model.Alumno;
import net.javaguides.springboot.springsecurity.model.Curso;
import net.javaguides.springboot.springsecurity.model.Matricula;
import net.javaguides.springboot.springsecurity.model.Profesor;
import net.javaguides.springboot.springsecurity.repository.AlumnoRepository;
import net.javaguides.springboot.springsecurity.repository.CursoRepository;
import net.javaguides.springboot.springsecurity.repository.MatriculaRepository;
import net.javaguides.springboot.springsecurity.repository.ProfesorRepository;
import net.javaguides.springboot.springsecurity.service.MatriculaService;

@Controller
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@GetMapping("/Matricula")
	public String viewHomePage(Model model) {
		return findPaginated(1, "id", "asc", model);		
	}

	@GetMapping("/showNewMatriculaForm")
	public String showNewEmpresaaForm(Model model) {

		List<Profesor> profesor = profesorRepository.findAll();
		model.addAttribute("profesor", profesor);
		
		List<Alumno> alumno =  alumnoRepository.findAll();
		model.addAttribute("alumno", alumno);
		
		List<Curso> curso =  cursoRepository.findAll();
		model.addAttribute("curso", curso);
		
		Matricula personaa = new Matricula(null, null, null);
		model.addAttribute("personaa", personaa);
		return "new_Matricula";
	}
	

	@PostMapping("/saveMatricula")
	public String saveEmpresaa(@ModelAttribute("personaa") Matricula personaa) throws UnsupportedEncodingException, MessagingException {
		// save employee to database
		String recipientEmail =personaa.getAlumno().getCorreo();
		String str_alumno =personaa.getAlumno().getNombre();
		String str_profesor =personaa.getProfesor().getNombre();
		String str_curso =personaa.getCurso().getNombre();
		double str_grado =personaa.getCurso().getGrado();
		
		matriculaService.saveMatricula(personaa);
		long str_idmatricula = personaa.getId();
		
	    sendEmail(recipientEmail, str_idmatricula, str_alumno, str_curso, str_grado, str_profesor);
	    

		return "redirect:/Matricula";
	}

	@GetMapping("/showFormForMatriculaUpdate/{id}")
	public String showFormForEmpresaUpdate(@PathVariable ( value = "id") long id, Model model) {
		Matricula personaa = matriculaService.getMatriculaId(id);
		model.addAttribute("personaa", personaa);
		
		List<Profesor> profesor = profesorRepository.findAll();
		model.addAttribute("profesor", profesor);
		
		List<Alumno> alumno =  alumnoRepository.findAll();
		model.addAttribute("alumno", alumno);
		
		List<Curso> curso =  cursoRepository.findAll();
		model.addAttribute("curso", curso);

		return "update_Matricula";
	}
	
	
	
	@GetMapping("/deleteMatricula/{id}")
	public String deletePersonaa(@PathVariable (value = "id") long id) {
		this.matriculaService.deleteMatriculaById(id);
		return "redirect:/Matricula";
	}
	
	
	@GetMapping("/pageMatricula/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5000;
		
		Page<Matricula> page = matriculaService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Matricula> listPersonaa = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPersonaas", listPersonaa);
		

		List<Matricula> listMatricula =  matriculaRepository.findAll();
		model.addAttribute("listMatricula", listMatricula);
		return "index_Matricula";
	}
	
	   
    @Autowired
	private JavaMailSender mailSender; 
    
    public void sendEmail(String recipientEmail, long str_idmatricula,String str_alumno,String str_curso,
    		double str_grado,String str_profesor)

            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();              
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom("samucux1@gmail.com", "Univesidad");
        helper.setTo(recipientEmail);
        
        String subject = "Matricula Registrada :  #"+str_idmatricula;
       
        String content =
        		"<style>.blacks{background:red;}</style><p>Hola</p>"
                + "<p>Estimado alumno "
        		+ str_alumno
                + "se ha matriculado exitosamente en el curso de "+str_curso+" del grado: "+str_grado
                + " dictado por el profesor: "+str_profesor
                + "<br>"+ "<br>"
                +"<p style=\"background: #bdf0fa; color: #0c92ac; font-weight: bold; padding: 15px; border: 2px solid #abecf9; border-radius: 6px;\">Curso Registrado: "
                +str_curso
                +"</p>";
         
        helper.setSubject(subject);
        helper.setText(content, true); 
        mailSender.send(message);	    }	    


	
}
