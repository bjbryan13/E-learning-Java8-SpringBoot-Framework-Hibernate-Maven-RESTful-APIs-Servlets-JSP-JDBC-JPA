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
import net.javaguides.springboot.springsecurity.model.Matricula;
import net.javaguides.springboot.springsecurity.model.Profesor;
import net.javaguides.springboot.springsecurity.repository.MatriculaRepository;
import net.javaguides.springboot.springsecurity.repository.ProfesorRepository;

@Service
public class MatriculaServcieImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository daoProf;
	
	@Override
	public Page<Matricula> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.daoProf.findAll(pageable);
	}

	@Override
	public void deleteMatriculaById(long id) {
		// TODO Auto-generated method stub
		this.daoProf.deleteById(id);		
	}

	@Override
	public List<Matricula> getAllMatricula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMatricula(Matricula personaa) {
		// TODO Auto-generated method stub
		this.daoProf.save(personaa);	
		
	}

	@Override
	public Matricula getMatriculaId(long id) {
		Optional<Matricula> optional = daoProf.findById(id);
		Matricula Matricula = null;
		if (optional.isPresent()) {
			Matricula = optional.get();
		} else {
			throw new RuntimeException(" Profesor no encontrado para id :: " + id);
		}
		return Matricula;
	
}

	
}
