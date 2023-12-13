package net.javaguides.springboot.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.springsecurity.model.Alumno;
import net.javaguides.springboot.springsecurity.model.Curso;
import net.javaguides.springboot.springsecurity.model.Profesor;
import net.javaguides.springboot.springsecurity.repository.AlumnoRepository;
import net.javaguides.springboot.springsecurity.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository daoCur;

	@Override
	public List<Curso> getAllCurso() {
		return  daoCur.findAll();

	}

	@Override
	public void saveCurso(Curso personaa) {
		this.daoCur.save(personaa);

	}

	@Override
	public Curso getCursoyId(long id) {
		Optional<Curso> optional = daoCur.findById(id);
		Curso Curso = null;
		if (optional.isPresent()) {
			Curso = optional.get();
		} else {
			throw new RuntimeException(" Curso no encontrado para id :: " + id);
		}
		return Curso;
	}

	@Override
	public void deleteCursoyId(long id) {
		this.daoCur.deleteById(id);		
	}

	@Override
	public Page<Curso> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.daoCur.findAll(pageable);
	}
	
	
	


}
