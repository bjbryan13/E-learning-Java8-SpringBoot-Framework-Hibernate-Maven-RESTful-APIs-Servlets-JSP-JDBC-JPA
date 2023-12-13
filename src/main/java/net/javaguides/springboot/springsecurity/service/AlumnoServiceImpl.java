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
import net.javaguides.springboot.springsecurity.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository daoProd;
	
	@Override
	public List<Alumno> getAllAlumno() {
		return  daoProd.findAll();
	}

	@Override
	public void saveAlumno(Alumno personaa) {
		this.daoProd.save(personaa);	
		
	}

	@Override
	public Alumno getAlumnoyId(long id) {
		Optional<Alumno> optional = daoProd.findById(id);
		Alumno Alumno = null;
		if (optional.isPresent()) {
			Alumno = optional.get();
		} else {
			throw new RuntimeException(" Alumno no encontrado para id :: " + id);
		}
		return Alumno;
	}

	@Override
	public void deleteAlumnoById(long id) {
		this.daoProd.deleteById(id);		
	}

	@Override
	public Page<Alumno> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.daoProd.findAll(pageable);
	}
	

}
