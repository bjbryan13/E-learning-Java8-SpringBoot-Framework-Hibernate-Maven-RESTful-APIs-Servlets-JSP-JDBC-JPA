package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.springsecurity.model.Profesor;


public interface ProfesorService {
	List<Profesor> getAllProfesor();
	void saveProfesor(Profesor personaa);
	Profesor getProfesorId(long id);
	void deleteProfesorById(long id);
	Page<Profesor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
