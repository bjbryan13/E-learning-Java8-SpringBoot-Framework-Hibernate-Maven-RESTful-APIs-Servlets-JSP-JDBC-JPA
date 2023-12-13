package net.javaguides.springboot.springsecurity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.springsecurity.model.Matricula;
import net.javaguides.springboot.springsecurity.model.Profesor;


public interface MatriculaService {
	List<Matricula> getAllMatricula();
	void saveMatricula(Matricula personaa);
	Matricula getMatriculaId(long id);
	void deleteMatriculaById(long id);
	Page<Matricula> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
