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
import net.javaguides.springboot.springsecurity.model.Profesor;
import net.javaguides.springboot.springsecurity.repository.ProfesorRepository;

@Service
public class ProfesorServcieImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository daoProf;
	
	@Override
	public List<Profesor> getAllProfesor() {
		// TODO Auto-generated method stub
		return  daoProf.findAll();
	}

	@Override
	public void saveProfesor(Profesor personaa) {
		// TODO Auto-generated method stub
		this.daoProf.save(personaa);	

	}

	@Override
	public Profesor getProfesorId(long id) {
		Optional<Profesor> optional = daoProf.findById(id);
		Profesor Profesor = null;
		if (optional.isPresent()) {
			Profesor = optional.get();
		} else {
			throw new RuntimeException(" Profesor no encontrado para id :: " + id);
		}
		return Profesor;
	}

	@Override
	public void deleteProfesorById(long id) {
		// TODO Auto-generated method stub
		this.daoProf.deleteById(id);		

	}

	@Override
	public Page<Profesor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.daoProf.findAll(pageable);
	}

}
